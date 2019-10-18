import filecmp
import glob
import os
import sys
import time
from subprocess import run

if len(sys.argv) != 2:
    print("Usage: python ccctest.py <java_class> <test_file_dir>")

if not os.path.exists("tmp"):
    os.mkdir("tmp")

cnt = 0
fail = []
for file in glob.glob(sys.argv[2] + "/*.in"):
    cnt += 1

    dir = os.path.dirname(file)
    base = os.path.basename(file)
    fname = os.path.splitext(base)[0]
    expected = "%s\%s.out" % (dir, fname)
    real = "tmp\%s.out" % (fname)

    fin = open(file, "r")
    fout = open(real, "w")
    cmd = "java -classpath out\production\CCC %s" % (sys.argv[1])
    print("[%d] %s < %s > %s" % (cnt, cmd, file, real))
    s = time.time()
    run(cmd, stdin=fin, stdout=fout)
    e = time.time()
    timeused = int(round((e - s) * 1000))
    fout.close()

    lexpected = [line.strip() for line in open(expected)]
    lreal = [line.strip() for line in open(real)]
    if lexpected == lreal:
        print("[PASS] %d ms" % (timeused))
    else:
        fail.append(file)
        print("[FAIL] %d ms. Expected: %s <=> Real: %s" % (timeused, lexpected, lreal))

print("=================================================================================================")
print("Total %d test cases. Failed %d. Passed %d." % (cnt, len(fail), cnt - len(fail)))