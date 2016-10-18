README FOR SCRIPTS

GITHUB README GENERATOR:
    Assumptions:
        OpenKattis (root) folder is structured as following:
        root folder contains folders per language (EG: "Java", "Python", "C")
        each language folder contains folders for the problems, named the same as the problem ID (case insensitive)
    
    Usage:
        Run the generator in the root folder of the OpenKattis folder (ie. the folder containing the language folders) using:
        python3 <PATH_TO_SCRIPTS_FOLDER>/generate_readme.py > README.md

    Options:
        To ignore problems (so they won't show up on the list) add a file named .ignore in the problem folder
        To mark problems as unsolved add a file named .unsolved in the problem folder


OTHER SCRIPTS

    Other scripts included are:
    dl_samples.sh: downloads the sample problems from the OpenKattis site based on the name of the folder you are in and unpacks them, and deletes the original zip file.
    iocheck_<LANGUAGE> checks the problem in the folder you are in against the sample data downloaded from Open Kattis

    Usage:
        The easiest way to use them would be to set them as aliases:
        To use the scripts in this folder add the following commands to your ~/.bash_profile if on mac, or ~/.bash_aliases if on UNIX
        Afterwards they can be used from the relevant folder.
        #OPEN KATTIS ALIASSES
        alias dl_samples="<PATH_TO_SCRIPTS_FOLDER>/dl_samples.sh"
        alias iocheck_python="<PATH_TO_SCRIPTS_FOLDER>/iocheck_python.sh"
        alias iocheck_java="<PATH_TO_SCRIPTS_FOLDER>/iocheck_java.sh"
        alias iocheck_c="<PATH_TO_SCRIPTS_FOLDER>/iocheck_c.sh"