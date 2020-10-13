#!/usr/bin/env python
# coding: utf-8

# In[162]:

from random import randint

def gen_random_string():
    st=""
    length=randint(10,20)
    for i in range(length):
        st=st+chr(randint(97,122))
    return st 

# <--------------------------------- Display Function ---------------------------------->
def display(li, include=True):
    li1 = [0]*len(li)
    count = 0
    if include:
        return li
    else:
        for i in range(len(li)):
            if li[i] != None:
                li1[count] = li[i]
                count += 1
    for i in range(count):
        if i == 0:
            print("[", end="")
        if i != (count-1):
            if type(li1[i]) == int:
                print(li1[i], end=", ")
            else:
                print("'" + li1[i] + "'", end=", ")
        else:
            print(li1[i], end="]")
            
            
# <--------------------------------- count_integers Function ---------------------------------->            
def count_integers(li):
    for ele in li:
        if ele != None:
            print(ele, end=", ")
            
            
# <--------------------------------- count_strings Function ---------------------------------->
def count_strings(li):
    for ele in li:
        if ele != None:
            print(ele, end=", ")            
            
# <--------------------------------- gen_random_list Function ---------------------------------->
def gen_random_list(len):
    li = [0]*len
    for i in range(len):
        li[i] = randint(1000, 2000)
    return li
        
# <--------------------------------- append Function ---------------------------------->
def append(li, new_li, start = False):
    li1 = [0]*(len(li) + len(new_li))
    li1_index_count = 0
    if start:
        for i in range(len(new_li)):
            li1[li1_index_count] = new_li[i]
            li1_index_count += 1
        for i in range(len(li)):
            li1[li1_index_count] = li[i]
            li1_index_count  += 1
    else:
        for i in range(len(li)):
            li1[li1_index_count] = li[i]
            li1_index_count  += 1
        for i in range(len(new_li)):
            li1[li1_index_count] = new_li[i]
            li1_index_count += 1
        
    print("Appended list   :", end="  ")
    print(li1)
    
# <--------------------------------- insert Function ---------------------------------->
def insert(li, str, index):
    li1 = [0]*(len(li)) 
    li1_index_count = 0
    for i in range(index):
        li1[li1_index_count] = li[i]
        li1_index_count += 1
    li1[index] = str
    li1_index_count += 1
    for i in range(index+1, len(li)):
        li1[li1_index_count] = li[i]
        li1_index_count += 1
    
    print(li1)
        
# <--------------------------------- Delete Function ---------------------------------->
def delete(li, index):
    for i in range(index, len(li)-1):
        li[i] = li[i+1]
    li[len(li)-1] = None
    return li

# <------------------------- Function for pushing all None elements to last(support for sorting functions) ----------------->
def push_None_to_end(li):
    count = len(li)-1
    i = 0
    while i < count:
        if li[i] == None and li[count] != None:
            li[i],li[count] = li[count],li[i]
            count -= 1
        elif li[count] == None:
            while True:
                count -= 1
                if li[count] != None:
                    break
            if li[i] == None and li[count] != None:
                li[i], li[count] = li[count], li[i]
                count -= 1
        i += 1 
        
# <------------------------------ Function for giving count(support for sorting functions) ---------------------------------->        
def give_count(li):
    count = -1
    for ele in li:
        if ele != None:
            count += 1
    return count

# <--------------------------------- Main Bubble Sorting Function ---------------------------------->
def bubble_sort_func(li):
    push_None_to_end(li)
    count = give_count(li)
    print(li)
#   Bubble sort
    for i in range(count):
        for j in range(count-i):
            if li[j]>li[j+1]:
                li[j], li[j+1] = li[j+1], li[j]

# <--------------------------------- Main Exchange Sorting Function ---------------------------------->
def exchange_sort_func(li):
    push_None_to_end(li)
    count = give_count(li)
    
#   Exchange Sort
    for i in range(count):
        minIndex = i
        for j in range(i+1, count+1):
            if li[j]<li[minIndex]:
                minIndex = j
                
        li[i], li[minIndex] = li[minIndex], li[i]

# <--------------------------------- Main Insertion Sorting Function ---------------------------------->
def insertion_sort_func(li):
    push_None_to_end(li)
    count = give_count(li)
    
#   Insertion Sort
    def insertion(arr, size, element):
        i = 0
        while element > arr[i]:
            i += 1
        for j in range(size-1, i-1, -1):
            arr[j+1] = arr[j]
        arr[i] = element
    
    for i in range(1, count+1):
        insertion(li, i, li[i])
    
# <---------------------------------For returning time taken to execute---------------------------------->
def bubble_sort(li):
    import time
    start = time.time()
    bubble_sort_func(li)
    end = time.time()
    return end-start
def exchange_sort(li):
    import time
    start = time.time()
    exchange_sort_func(li)
    end = time.time()
    return end-start
def insertion_sort(li):
    import time
    start = time.time()
    insertion_sort_func(li)
    end = time.time()
    return end-start

# <--------------------------------- Give Sorted Indexes Function ---------------------------------->
def display_indexes_after_sort(li, arr):
    push_None_to_end(li)
    count = give_count(li)
        
    li1 = [None]*(count+1)# For making a copy of unsorted list
    arr = [None]*(count+1)
    repeat = [None]*(count+1)
    for i in range(count+1):
        li1[i] = li[i]
    bubble_sort_func(li)
    for i in range(count+1):
        for j in range( count+1):
            if li1[j] == li[i] and j not in repeat:
                arr[i] = j
                repeat[i] = j
                
# <--------------------------------- Main Driver Code ---------------------------------->
sorted_indexes=[]
my_int_list=[None]*100
for i in range(100):
    my_int_list[randint(0,99)]=randint(-200,200)
my_str_list=[None]*100
for i in range(100):
    my_str_list[randint(0,99)]=gen_random_string()
choice=0
while choice!= 100:
    print()
    sentence="********************Main Menu***********************************"
    screen_width = 80
    text_width   = len(sentence)
    box_width    = text_width + 6
    left_margin  = (screen_width - box_width) // 2
    print()
    print(' ' * left_margin + '+'   + '-' * (box_width-2)  +   '+')
    print(' ' * left_margin + '|  ' + ' ' * text_width+ '  |')
    print(' ' * left_margin + '|  ' +       sentence+ '  |')
    print(' ' * left_margin + '|  ' +       "1. Display Integer List"+ " "*41+'  |')
    print(' ' * left_margin + '|  ' +       "2. Display String List"+ " "*42+'  |')
    print(' ' * left_margin + '|  ' +       "3. Count Integer Elements"+ " "*39+'  |')
    print(' ' * left_margin + '|  ' +       "4. Count String Elements"+ " "*40+'  |')
    print(' ' * left_margin + '|  ' +       "5. Append another Integer List"+ " "*34+'  |')
    print(' ' * left_margin + '|  ' +       "6. Insert a String  in String List"+ " "*30+'  |')
    print(' ' * left_margin + '|  ' +       "7. Delete an element at an Index"+ " "*32+'  |')
    print(' ' * left_margin + '|  ' +       "8. Bubble Sort"+ " "*50+'  |')
    print(' ' * left_margin + '|  ' +       "9. Exchange Sort"+ " "*50+'|')
    print(' ' * left_margin + '|  ' +       "10. Insertion Sort"+ " "*48+'|')
    print(' ' * left_margin + '|  ' +       "11. Display the original indexes of elements after sort"+ " "*9+'  |')
    print(' ' * left_margin + '|  ' +       "100. E X I T "+ " "*53+'|')
    print(' ' * left_margin + '|  ' + ' ' * text_width+ '  |')
    print(' ' * left_margin + '+'   + '-' * (box_width-2)  +   '+')
    print()
    print("Enter your Choice[0-11] 100 to Quit: ")
    choice=int(input())
    if choice==1:
        display(my_int_list,include=False) ###Displays the whole list if include=True else displays only elements which are not None
    elif choice ==2:
        display(my_str_list,include=False) ###Displays the whole list if include=True else displays only elements which are not None

    elif choice==3:
        count_integers(my_int_list)  # Display all integers excluding None
    elif choice==4:
        count_strings(my_str_list)    # Display all Strings excluding None
    elif choice==5:
        new_list=gen_random_list(10)   # Generates a random list of 10 elements (between 1000 and 2000)
        print("The New List is : ",new_list)
        append(my_int_list,new_list,start=True)  # Inserts the new list in the start if start=True else at the end if start is False
        
    elif choice==6:
        new_string=gen_random_string()
        print("The new String is : ",new_string)
        position=int(input("New String to be inserted at : "))
        
        insert(my_str_list,new_string,position) ## Inserts the new string  at the given position
              
    elif choice==7:
        position=int(input("Element to be deleted at (Specify the index): "))
        delete(my_int_list,position)   ## Deletes the integer element at the given position
        print("The list after deletion is :")
        display(my_int_list,include=False)
        
    elif choice==8:
        time=bubble_sort(my_str_list) ## Bubble sorts the string list and returns the time taken to sort
        print("Time taken to print my sorted list is ", time)
        print("Sorted List is :")
        display(my_str_list,include=False)
        
        
    elif choice==9:
        time=exchange_sort(my_int_list) ## Exchange sorts(You may use selection sort ) the integer list and returns the time taken to sort
        print("Time taken to print my sorted list is ", time)
        print("Sorted List is : ")
        display(my_int_list,include=False)
        
    elif choice==10:
        time=insertion_sort(my_str_list) ## Insertion sorts the string list and returns the time taken to sort
        print("Time taken to print my sorted list is ", time)
        print("Sorted List is : ")
        display(my_str_list,include=False)
    elif choice==11:
        display_indexes_after_sort(my_int_list,sorted_indexes)
        ### This function displays the indexes of the sorted elements
        ### for example if the list is [9, 2, 7, 5, 4]
        ### It will display [1,4,3,2,0] i.e. [ index of 2,index of 4, index of 5, index 0f 7, index of 9]

# In[ ]:





