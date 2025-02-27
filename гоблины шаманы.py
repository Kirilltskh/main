import sys
from collections import deque

def main():
    input = sys.stdin.read
    data = input().splitlines()
    
    N = int(data[0])
    queue = deque()
    output = []
    
    for i in range(1, N + 1):
        command = data[i]
        
        if command[0] == '+':
            goblin_number = int(command[2:])
            queue.append(goblin_number)
        
        elif command[0] == '*':
            goblin_number = int(command[2:])
            mid = (len(queue) + 1) // 2
            queue.insert(mid, goblin_number)
        
        elif command[0] == '-':
            output.append(queue.popleft())
    
    print('\n'.join(map(str, output)))

if __name__ == '__main__':
    main()
