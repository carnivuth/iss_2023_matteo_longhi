#!/bin/bash 

# usefull variables
TMP="body.html"
TITLE="title.txt"
NAME="Matteo"
SURNAME="Longhi"
IMAGE_FOLDER="assets"
IMAGE_FOLDER_DIR="/home/matteo/appunti/ingegneria_sistemi_software/"
OUTPUT_FOLDER="Deliverables/userDocs/"
TEMPLATE_FOLDER="templates/"
TEMPLATE="LonghiMatteoTemplate.html"

#check arguments
 [[ "$#" -ne 2 ]] && echo "wrong number arguments" && exit
 #[[ -f "$1" ]] || echo "arguments $1 not a file" && exit

#converting markdown to html
 md2html "$1" -o "$TMP"
 echo "$2" > "$TITLE"
 #creating file from template
 cpp -P $TEMPLATE_FOLDER$TEMPLATE -o "$OUTPUT_FOLDER$2.html" 2>/dev/null
 #coping assets
 cp -r "$IMAGE_FOLDER_DIR$IMAGE_FOLDER" Deliverables/
 #removing body
 rm "$TMP"
rm "$TITLE"
 #update repo
 git add "Deliverables/$IMAGE_FOLDER/*"
 git add "$OUTPUT_FOLDER/*"
 git commit -m "added $2"
 git push

 
