#python bin/ccctest.py S2018.Q2 C:\github\CCC\testdata\y18\J4S2

import filecmp
import glob
import os
import sys
import time
import subprocess

if len(sys.argv) != 3:
    print("Usage: python ccctest.py <java_class> <test_file_dir>")

clazz = sys.argv[1]
path = sys.argv[2]
timeout = 10        # seconds

if not os.path.exists("tmp"):
    os.mkdir("tmp")

def run(file, cnt):
    dir = os.path.dirname(file)
    base = os.path.basename(file)
    fname = os.path.splitext(base)[0]
    expected = "%s\%s.out" % (dir, fname)
    real = "tmp\%s.out" % (fname)

    fin = open(file, "r")
    fout = open(real, "w")
    cmd = "java -classpath out\production\CCC %s" % (clazz)
    print("[%d] %s < %s > %s" % (cnt, cmd, file, real))
    s = time.time()
    try:
        ret = subprocess.run(cmd, stdin=fin, stdout=fout, timeout=timeout)
    except Exception as e:
        print("[FAIL] %s." % str(e)) # (sys.exc_info()[0]))
    e = time.time()
    timeused = int(round((e - s) * 1000))
    fout.close()

    lexpected = [line.strip() for line in open(expected)]
    lreal = [line.strip() for line in open(real)]
    if lexpected == lreal:
        print("[PASS] %d ms" % (timeused))
        return True
    else:
        print("[FAIL] %d ms. Expected: %s <=> Real: %s" % (timeused, lexpected, lreal))
        return False

if os.path.isdir(path):
    cnt = 0
    fail = []
    for file in glob.glob(sys.argv[2] + "/*.in"):
        cnt += 1
        if not run(file, cnt):
            fail.append(file)

    print("=================================================================================================")
    print("Total %d test cases. Failed %d. Passed %d." % (cnt, len(fail), cnt - len(fail)))
else:
    run(path, 1)