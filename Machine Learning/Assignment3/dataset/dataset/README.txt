This README describes the various files created for 2022S2 COMP90049 Project 3.

There are various files in these archives: other than this README, each one can be identified by its filename, in the format {set}_{type}.{filetype}
- {set} refers to either train, dev, or test:
    train: You should use this data when building a model for training.
    dev: You should use this data when evaluating a model.
    test: You should submit the outputs on this data to Kaggle; the labels are not given
    Unlabelled: You should use this data for semi-supervise or unsupervised learning.
   
- {type} refers to either raw, tfidf, embedding:
    Raw: This contains the raw text of the corresponding comments, one comment per line, in the following format:
          ID,Toxicity,Identities(24 columns), Comment
          where Toxicity is the class label (to be predicted). Identities describe whether  the comment refers to 24 identities such as female, male and so on. ID is the comment index, and the Comment is the raw comment text.
                    
    tfidf: For these files, we have pre-processed the corresponding comments, and have recorded the tfidf (term frequency inverse document frequency) value of a subset of words (pre-filtered by tfidf). 
    
    Embedding: For these files, we have mapped each comment to a 384-dim embedding computed by a pre-trained sentence embedding model (Sentence Transformer).
    
        
Finally, 'vocabulary.csv' contains the 1000 words used in TFIDF (underlying the tfidf files), mapping each word to a unique identifier (index in embedding), of the form 
    Index \tab Word (newline).

