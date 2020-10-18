from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys

class InstaBot:
    def __init__(self,username,pw):
        self.driver = webdriver.Chrome()
        self.driver.get("https://instagram.com")
        time.sleep(2)
        self.username = username

        username_input = self.driver.find_element_by_xpath('//input[@name="username"]')
        username_input.send_keys(username)
        self.driver.find_element_by_xpath('//input[@name="password"]').send_keys(pw)
        
        self.driver.find_element_by_xpath('//button[@type="submit"]').click()
        time.sleep(5)

        self.driver.find_element_by_xpath("//button[contains(text(), 'Not Now' )]").click()
        time.sleep(2)

        self.driver.find_element_by_xpath("//button[contains(text(), 'Not Now' )]").click()

        time.sleep(10)


    def get_unfollowers(self):
        self.driver.find_element_by_xpath("//a[contains(@href,'/{}')]".format(self.username)).click()
        time.sleep(5)
        self.driver.find_element_by_xpath("//a[contains(@href,'/following')]").click()

        following = self.get_names()
        
        self.driver.find_element_by_xpath("//a[contains(@href,'/followers')]").click()

        followers = self.get_names()

        not_followiing_back = [names for names in following if names not in followers]

        print(not_followiing_back)


    def get_names(self):
        time.sleep(2)
        scroll_box = self.driver.find_element_by_xpath("/html/body/div[4]/div/div/div[2]")
        last_ht, ht = 0, 1
        while last_ht != ht:
            last_ht = ht
            time.sleep(1)
            ht = self.driver.execute_script("""
                arguments[0].scrollTo(0, arguments[0].scrollHeight); 
                return arguments[0].scrollHeight;
                """, scroll_box)
        links = scroll_box.find_elements_by_tag_name('a')
        names = [name.text for name in links if name.text != '']
        # close button
        self.driver.find_element_by_xpath("/html/body/div[4]/div/div/div[1]/div/div[2]/button").click()
        return names

    
my_bot = InstaBot('Enter your Username','Enter Your Password')
my_bot.get_unfollowers()
