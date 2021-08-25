"""
blueberryCheeseSales.docx
"blueberryCheeseSales" - docx

mushroom_promo_photo
Jpeg
"mushroom_promo_photo" - jpeg
"""

import sys

def main():
    input = sys.stdin.readline
    line = input().rstrip('\n')
    idx = line.find(".")
    if idx != -1:
        print(f'"{line[:idx]}" - {line[idx+1:].lower()}')
    else:
        ext = input().rstrip('\n').lower()
        print(f'"{line}" - {ext}')
main()