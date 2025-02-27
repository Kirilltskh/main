import sys

def main():
    N = int(input().strip())
    cars = list(map(int, input().strip().split()))
    
    stack = []
    expected = 1
    
    for car in cars:
        while stack and stack[-1] == expected:
            stack.pop()
            expected += 1
            
        if car == expected:
            expected += 1
        else:
            stack.append(car)
    
    while stack and stack[-1] == expected:
        stack.pop()
        expected += 1
    
    if expected == N + 1:
        print("YES")
    else:
        print("NO")

if __name__ == '__main__':
    main()
