import re

myText = "ksdgkgfkd11212 weqfdhq 32131 hello kggfjgf 111" \
         "ehofdwhof hello google yandex apple kitten dog" \
         "eat tea hjhdjsd 2388 0kfhohf 0988 oh lh l h Aksjdfks" \
         "ldlfh Jspdjfpsdjf lhkljfhw.wdpfij google.com"

pattern = r"hello"
allResults = re.findall(pattern, myText)
print(allResults)

print(re.findall(r"\d\d\d",myText))
print(re.findall(r"[0-9]{4}",myText))
print(re.findall(r"\w",myText))
print(re.findall(r"\w{6}\s",myText))
print(re.findall(r"[A-Z][a-z]+",myText))
print(re.findall(r"\w+\.\w+",myText))



