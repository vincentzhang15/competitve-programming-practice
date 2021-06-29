def nextTerm(one, two):
    return one-two

def doQuestion(t1, t2):
    terms = 2
    
    while True:
        tn = nextTerm(t1, t2)
        terms += 1
        if t2 < tn:
            print(terms)
            return
        t1 = t2
        t2 = tn

t1 = int(input())
t2 = int(input())
doQuestion(t1, t2)