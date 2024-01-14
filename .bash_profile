
# >>> conda initialize >>>
# !! Contents within this block are managed by 'conda init' !!
__conda_setup="$('/Users/AliJoammis/opt/anaconda3/bin/conda' 'shell.bash' 'hook' 2> /dev/null)"
if [ $? -eq 0 ]; then
    eval "$__conda_setup"
else
    if [ -f "/Users/AliJoammis/opt/anaconda3/etc/profile.d/conda.sh" ]; then
        . "/Users/AliJoammis/opt/anaconda3/etc/profile.d/conda.sh"
    else
        export PATH="/Users/AliJoammis/opt/anaconda3/bin:$PATH"
    fi
fi
unset __conda_setup
# <<< conda initialize <<<


# Setting PATH for Python 3.10
# The original version is saved in .bash_profile.pysave
PATH="/Library/Frameworks/Python.framework/Versions/3.10/bin:${PATH}"
export PATH

export PATH="/usr/local/opt.icu4c/bin:$PATH"
