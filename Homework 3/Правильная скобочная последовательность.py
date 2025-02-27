import sys

def main():
    stack = []
    brackets = {')': '(', ']': '[', '}': '{'}
    
    sequence = input().strip()
    
    for char in sequence:
        if char in brackets.values():
            stack.append(char)
        elif char in brackets.keys():
            if not stack or stack.pop() != brackets[char]:
                print("no")
                return
    
    print("yes" if not stack else "no")

if __name__ == '__main__':
    main()
