Modifications made to the original Argv package from software.charlie-dog.com:
==============================================================================
- Added ArgvTest class to test directory.
- Added sub-classes DoubleOption and IntOption and their Parameter classes.
- Added String constructor to ArgumentParser to allow to set the program name, printed in Usage.
- Added name of parameter to StringOption, PairOption, NumberOption, DoubleOption and IntOption.
- Added MissingArgumentException and ArgumentFormatException.
- Renamed arguments to options in ArgumentParser.
- Added addParameter and addOption methods to ArgumentParser
- Renamed all ...Argument classes to ...Option classes 
- Split Argument in Option and Parameter interface.
- Added ...Parameter classes
- Changed printUsage to handle proper widths for printing Usage
- Added BailOutException for internal use, to abort parsing arguments and return (for instance to show help or version).
- Added MultiStringOption to allow for mulitple occurences of options such as -I
