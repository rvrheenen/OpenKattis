while true; 
do
    i=$[$i+1]
    java GenerateBoard > input.txt
    if [ `cat input.txt | java EightQueens` == `cat input.txt | java SecondOpinion` ]
    then echo "$i: same answer"
    else echo "$i: FOUND DIFFERENCE!!!!"
        cp input.txt found/$i.txt
    fi 
done
