import sys
from collections import defaultdict

N = int(sys.stdin.readline())
extension_dict = defaultdict(int)

for _ in range(N):
    file_name = sys.stdin.readline().rstrip()
    name = file_name.split('.')
    extension_dict[name[1]] += 1
extension_list = list(extension_dict.keys())
extension_list.sort()

for extension in extension_list:
    print(extension, extension_dict[extension])