#!/bin/bash

#detect names of file and input files
filename=($(ls *.rs))
testdataname=($(ls *.in))

rustc $filename

for f in "${testdataname[@]}"; do
    if [ -n "$filename" ] && [ -n "$testdataname" ]
      then
      #strip off the extensions
      basename=${filename%.rs}
      dataname=${f%.in}
      
      #run
      if ./$basename < $f > $dataname.output
        then

        #diff the judge's output and the program output
        diffResult="$(diff -b $dataname.ans $dataname.output)"
      
        if [ -n "$diffResult" ]
          then
            echo $f
            echo $diffResult
            echo "Solution $dataname is not correct."
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
