# -*- coding: utf-8 -*-
from __future__ import absolute_import
from __future__ import division, print_function, unicode_literals
from sumy.parsers.html import HtmlParser
from sumy.parsers.plaintext import PlaintextParser
from sumy.nlp.tokenizers import Tokenizer
from sumy.summarizers.lsa import LsaSummarizer
from sumy.summarizers.text_rank import TextRankSummarizer
from sumy.nlp.stemmers import Stemmer
from sumy.utils import get_stop_words
import sys
#reload(sys) #Enable this line in UNIX
#sys.setdefaultencoding('utf8') #Enable this line in UNIX

LANGUAGE = "english"
    
if __name__ == "__main__":
    #If 30 is entered it gives 30 sentences, if 30% is entered it gives 30% of original article
    SENTENCES_COUNT=str(sys.argv[1])
    IN_STR = sys.argv[2].decode('base64') 
    parser = PlaintextParser.from_string(IN_STR,Tokenizer(LANGUAGE))
    stemmer = Stemmer(LANGUAGE)
    summarizer = TextRankSummarizer(stemmer)
    summarizer.stop_words = get_stop_words(LANGUAGE)
    sentences=summarizer(parser.document, SENTENCES_COUNT)
    for sentence in summarizer(parser.document, SENTENCES_COUNT):
        print(str(sentence)+"\n")