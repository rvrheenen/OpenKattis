#!/bin/bash

#detect names of file and input files
filename=($(ls *.py))
testdataname=($(ls *.in))

#if these files are present...
for f in "${testdataname[@]}"; do
    if [ -n "$filename" ] && [ -n "$testdataname" ]
      then
      #strip off the extensions
      basename=${filename%.py}
      dataname=${f%.in}
      
      #run
      if cat $f | python3 $filename  > $dataname.output
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
rm *.output