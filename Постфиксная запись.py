import sys

def main():
    stack = []
    
    expression = input().strip().split()
    
    for token in expression:
        if token.isdigit() or (token[0] == '-' and token[1:].isdigit()):
            stack.append(int(token))
        elif token in ('+', '-', '*'):
            b = stack.pop()
            a = stack.pop()
            if token == '+':
                stack.append(a + b)
            elif token == '-':
                stack.append(a - b)
            elif token == '*':
                stack.append(a * b)
    
    print(stack[0])

if __name__ == '__main__':
    main()
