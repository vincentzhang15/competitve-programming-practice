# http://www.cis.jhu.edu/~sachin/digit/digit.html
# https://stackoverflow.com/questions/2872381/how-to-read-a-file-byte-by-byte-in-python-and-how-to-print-a-bytelist-as-a-binar

file1 = open('nums0.txt', 'w')
file1.write("1000\n")

with open("data0.txt", 'rb') as f:
   for r in range(1000):
      for i in range(1, 28*28+1):
         byte_s = f.read(1)
         if not byte_s:
            break
         byte = byte_s[0]
         line = str("%.6f" % (byte / 255))
         if i % 28 == 0:
            line += "\n"
         else:
            line += " "
         file1.write(line)
file1.close()