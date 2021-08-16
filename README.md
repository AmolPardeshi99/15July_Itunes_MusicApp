# 15July_Itunes_MusicApp
iTunes API Submitted
Problem
Design an Android app with the below requirements

Given

Request Type : GET
Base Url : https://itunes.apple.com/
End Point : /search?term=#searchTerm
The query searchTerm has to be entered via search view.

Examples

https://itunes.apple.com/search?term=baby
https://itunes.apple.com/search?term=shapeofyou
Requirements

A search box that allows the user to search for an artist. This term is passed to the iTunes API in place of the #searchTerm parameter.
Show the List of details in a Recycler View that has a grid view with 3 columns.
The recycler view must display the artist name, track name, track image, play/pause button and delete button.
On click of the play button, load the song the url
On click of pause button, pause the song
On click of delete, the item should be removed from the list
