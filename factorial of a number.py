def factorial(n):
    product=1
    for i in range(1,n+1):
        product=product*i
    return product
n=int(input('Enter a positive number:'))
if n<0:
    print('Factorial is not defined on negative number')
else:
    f=factorial(n)
    print('Factorial of ',n,'is',f)
