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

ALPHABET = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
NYSE_URL = "http://www.advfn.com/nyse/newyorkstockexchange.asp?companies="

def scrapeNYSE(limit):
	''' Scrapes the website up to and including 
	    some LIMIT.
	'''
	br = webdriver.Firefox()
	nyseNameAndID = {}
	tempNameId={}

	for let in ALPHABET:
    time.sleep(2)
    br.get(urlofnyse+str(let))
    tobesoup=br.page_source
    soup=BeautifulSoup(tobesoup)
    nameandid=soup.find('table',{'class':'market tab1'})
    for x in nameandid.find_all('tr'):
        try:
            x['class']
        except KeyError:
            continue
        if re.search(r'ts',str(x['class']))!=None:
            nameandidactual=x.find_all('td')
            tempnameid['Name']=nameandidactual[0].text
            tempnameid['ID']=nameandidactual[1].text
            nysenameandid[str(i)]=tempnameid
            tempnameid={}
            i=i+1
        else:
            continue

