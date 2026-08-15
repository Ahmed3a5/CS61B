def evens(list_of_ints):
    return_list = []
    for i in range(len(list_of_ints)):
        if list_of_ints[i]%2 == 0:
            return_list.append(list_of_ints[i])

    return return_list

lis = [1 , 2 , 5, 8, 6, 12 , 10, 9, 0]

# print(evens(lis))

def count_words(list_of_words):

    counts = {}

    for i in range(len(list_of_words)):
        if list_of_words[i] in counts.keys():
            counts[list_of_words[i]] +=1

        else:
            counts[list_of_words[i]] = 1

    return counts


list_of_words = ['ahmed' , 'mohamed' , 'ahmed' , 'ashraf' , 'mohamed', 'samir']
# print(count_words(list_of_words))

class Dog():
    def __init__(self , name , size):
        self.name = name
        self.size = size

    def __str__(self):
        message = self.name + ' the size ' + str(self.size)+ ' dog'
        return message 

    def grow(self):
        self.size = self.size + 1


# dogs = [Dog("maya", 1000), Dog("yipster", 5), Dog("scott", 25)]
# print(dogs[0])
# dogs[0].grow()
# print(dogs[0])

def listofflowers(L):

    mydict = {}

    for i in range(len(L)):
        if i == len(L)-1:
            return mydict
        elif L[i] in mydict.keys():
            mydict[L[i]].append(L[i+1])
        else:
            mydict[L[i]] = [L[i+1]]


    return mydict


# mylist = ["I", "love", "java", "but", "I", "love", "python", "more"]
# print(listofflowers(mylist))


def swap(array , index1 , index2):
    array[index1] , array[index2] = array[index2] , array[index1]


def findsmallestindex(array , start ):
    smallestindex = start
    for i in range(start , len(array)):
        if array[i] < array[smallestindex]:
            smallestindex = i

    return smallestindex

def selcetionsort(array , start):
    if start >= len(array):
        return array
    smallestindex = findsmallestindex(array ,start )
    swap(array,start , smallestindex)

    return selcetionsort(array , start+1)

# array = [2,5,7,3,1,4,6]
# print(selcetionsort(array , 0))

# starsnum = 1
# for i in range(5,0,-1):
#     print(" "*i + "*"*starsnum)
#     starsnum+=1


def starstriangle(n):
    starsnum = 1
    for i in range(n,0,-1):
        print(" "*i + "*"*starsnum)
        starsnum+=1

# starstriangle(8)

def reversedinex(word):
    newword =''
    for i in range(len(word)):
        reversindex = (len(word)-1) - i
        newword += word[i] + str(reversindex)

    return newword

# print(reversedinex('hello'))

def doublestring(word):

    newword = ''
    for i in range(len(word)):
        newword += word[i] + word[i]

    return newword

# print(doublestring('hello'))

