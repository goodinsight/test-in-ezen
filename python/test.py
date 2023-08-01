from urllib.request import urlopen
from bs4 import BeautifulSoup
import pymysql
import random
import urllib.error
import base64
from io import BytesIO
from PIL import Image
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

service = Service('D:\Downloads\chromedriver-win64') # 크롬 드라이버 다운받아서 위치 지정
options = webdriver.ChromeOptions()
driver = webdriver.Chrome(service=service, options=options)
conn = pymysql.connect(host="127.0.0.1", user="root", password="12345", db="movieDB", charset="utf8")
cur = conn.cursor()
succese = []
fail = []
while(len(succese)!= 1000):
    try:
        ran = random.randint(1, 170000)
        if not(ran in succese and ran in fail):
            movie = ["null" for i in range(12)]
            response = urlopen("https://movie.daum.net/moviedb/main?movieId=%d"%(ran))
            soup = BeautifulSoup(response, "html.parser")

            title = soup.find("span", {"class": "txt_tit"})
            movie[0] = (title.get_text().split("<span class=\"txt_tit\">")[0])

            dd = soup.find_all("dd")
            dt = soup.find_all("dt")
            print(dt)
            if("<dt>개봉</dt>" in dt):
                for j in range(len(dd)):
                    if(dt[j].get_text() == "개봉"):
                        data = dd[j].get_text().split()
                        movie[1] = data
                    elif(dt[j].get_text() == "재개봉"):
                        data = dd[j].get_text().split()
                        movie[2] = data
                    elif(dt[j].get_text() == "장르"):
                        data = dd[j].get_text().split()
                        movie[3] = data
                    elif(dt[j].get_text() == "국가"):
                        data = dd[j].get_text().split()
                        movie[4] = data
                    elif(dt[j].get_text() == "등급"):
                        data = dd[j].get_text().split()
                        movie[5] = data
                    elif(dt[j].get_text() == "러닝타임"):
                        data = dd[j].get_text().split()
                        movie[6] = data
                    elif(dt[j].get_text() == "평점"):
                        data == dd[j].get_text().split()
                        movie[7] = data
                    elif(dt[j].get_text() == "누적관객"):
                        data == dd[j].get_text().split()
                        movie[8] = data
                    elif(dt[j].get_text() == "수상내역"):
                        data == dd[j].get_text().split()
                        movie[9] = data
                sql = "INSERT INTO movie (m_name, m_opening, m_reopening, m_genre, m_nation, m_age, m_runtime, m_grade, m_attendance, m_awards)values(%s, %s, %s, %s, %s, %s, %s, %s ,%s ,%s)"

                cur.execute(sql, (movie[0], movie[1], movie[2], movie[3], movie[4], movie[5], movie[6], movie[7], movie[8], movie[9]))
                conn.commit()
               
                # driver 연동 방식
                url =  ("https://movie.daum.net/moviedb/main?movieId=%d"% ran)
           
           
                driver.get(url)
                   

                search_box = driver.find_element(By.XPATH, '//*[@id="mainContent"]/div/div[2]/div[1]/ul/li[1]/a/span')
                actions = webdriver.ActionChains(driver).move_to_element(search_box)
                actions = webdriver.ActionChains(driver).click(search_box)
                # time.sleep(1)
                actions.perform()

                soup = BeautifulSoup(driver.page_source, 'html.parser')
                #response = urlopen(url)
                #soup = BeautifulSoup(response, "html.parser")
                   
                   
                director = soup.select('dd>a')[7].text
                print(director)
                #director = soup.find_all('div','thumb_cont')
                #print(director)

                   
                sql = "update movie set m_awards = %s where m_name = %s"

                cur.execute(sql, (director, movie[0]))
                conn.commit()
               
                succese.append(ran)
                print("%d 번째 성공" % len(succese))
            else:
                fail.append(ran)
                print("%d 번째 실패" % len(fail))
    except:
        print("%d 번째에서 오류" % ran)
        conn.commit()
        pass