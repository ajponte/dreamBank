from mechanize import *
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
import time
import urllib2
import unidecode
from unidecode import unidecode
import re
import json


#yahoo finance bond rates for treasury, municipal, and corporate bonds


yahoofinancebondurl="http://finance.yahoo.com/bonds/composite_bond_rates"

def getBondData():
    br = webdriver.Firefox()
    br.get(yahoofinancebondurl)
    bondhtml = br.page_source
    bondsoup = BeautifulSoup(bondhtml)
    headers=['Maturity','Yield','Yesterday','Last Week','Last Month']
    dictforbonds={}
    dictforbondname={}
    for x in bondsoup.find_all('table'):
        try:
            x.find('caption').text
        except AttributeError:
            continue
        chalk = x.caption.text
        if re.search(r'Bonds',str(x.caption.text))!=None:
            charm = x.tbody.find_all('tr')
            for b in charm:
                for y,q in zip(b.find_all('td'),headers):
                    if q in dictforbondname.keys():
                        dictforbondname[q].append(str(y.text))
                    else:
                        dictforbondname[q]=[str(y.text)]
            dictforbonds[chalk]=dictforbondname
            dictforbondname={}
    return dictforbonds

if __name__ == "__main__":
    bondData = getBondData()
    print bondData
        
