import sys

input_string = list(sys.stdin.readline().rstrip())
reverse_string = []
output_string = ''
is_reverse = True

for string in input_string:
    if string == '<':
        while reverse_string:
            output_string += reverse_string.pop()
        is_reverse = False
        output_string += string
        continue
    elif string == '>':
        is_reverse = True
        output_string += string
        continue
    elif string == ' ' and is_reverse:
        while reverse_string:
            output_string += reverse_string.pop()
        output_string += string
        continue

    if is_reverse:
        reverse_string.append(string)
    else:
        output_string += string

while reverse_string:
    output_string += reverse_string.pop()
print(output_string)