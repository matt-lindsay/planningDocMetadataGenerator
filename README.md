## Planning Doc Meta-data Generator

This processor is used for ad-hoc bulk import jobs to build XML meta-data files for documents awaiting import into Alfresco Community Edition. The source of meta-data in this instance is a CSV file.

The CSV file schema has to be in the following order which conforms to the DublinCore meta data standard. If another meta-data standard is being used the field order will change and the XmlGenerator object will have to be modified.

Fields:

1. Title
2. Description
3. Created (use following date format to avoid input errors '2015-10-10')
4. Author
5. Publisher
6. Contributor
7. Type (PDF, TIFF etc.)
8. Identifier (Import path e.g. Windows 'C:\Documents\doc1.pdf' or Linux '/home/user/Documents/doc1.pdf')
9. Source
10. Coverage
11. Rights (Alfresco user group rights)
12. Subject
13. Path (Output path to save XML file to. Include the file name).

The CSV fields are separated by commas. The are no text delimiters assumed.

There should be one XML meta-data file per document awaiting import.