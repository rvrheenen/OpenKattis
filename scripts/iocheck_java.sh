#!/bin/bash

#detect names of file and input files
filename=($(ls *.java))
testdataname=($(ls *.in))

javac $filename

for f in "${testdataname[@]}"; do
    if [ -n "$filename" ] && [ -n "$testdataname" ]
      then
      #strip off the extensions
      basename=${filename%.java}
      dataname=${f%.in}
      
      #run
      if java $basename < $testdataname > $dataname.output
        then

        #diff the judge's output and the program output
        diffResult="$(diff -b $dataname.ans $dataname.output)"
      
        if [ -n "$diffResult" ]
          then
            echo $f
            echo $diffResult
            echo "Solution is not correct."
          else
            echo "Solution is correct."
        fi
      else
        echo "Compilation or run time error"
      fi
    else
      echo "Missing files"
    fi
done

#clean up
rm *.class
rm *.output