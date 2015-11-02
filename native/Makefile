CC=gcc
CFLAGS_PPC=-arch ppc -O2 -funroll-loops 
CFLAGS_I386=-arch i386 -O2 -funroll-loops -mtune=i686
CFLAGS_X86_64=-arch x86_64 -O3 -Ofast -funroll-loops
# -mtune=i686

INCLUDES=-I/System/Library/Frameworks/JavaVM.framework/Versions/Current/Headers

# Exclude PPC version (no longer compiles on Lion)
all: libNucleotideLikelihoodCore.i386.jnilib libNucleotideLikelihoodCore.x86_64.jnilib \
	libAminoAcidLikelihoodCore.i386.jnilib libAminoAcidLikelihoodCore.x86_64.jnilib \
	libGeneralLikelihoodCore.i386.jnilib libGeneralLikelihoodCore.x86_64.jnilib 
	lipo -create libNucleotideLikelihoodCore.i386.jnilib libNucleotideLikelihoodCore.x86_64.jnilib -output libNucleotideLikelihoodCore.jnilib
	lipo -create libAminoAcidLikelihoodCore.i386.jnilib libAminoAcidLikelihoodCore.x86_64.jnilib -output libAminoAcidLikelihoodCore.jnilib
	lipo -create libGeneralLikelihoodCore.i386.jnilib libGeneralLikelihoodCore.x86_64.jnilib -output libGeneralLikelihoodCore.jnilib


#all: libNucleotideLikelihoodCore.PPC.jnilib libNucleotideLikelihoodCore.i386.jnilib libNucleotideLikelihoodCore.x86_64.jnilib \
	 libAminoAcidLikelihoodCore.PPC.jnilib libAminoAcidLikelihoodCore.i386.jnilib libAminoAcidLikelihoodCore.x86_64.jnilib 
#	lipo -create libNucleotideLikelihoodCore.PPC.jnilib libNucleotideLikelihoodCore.i386.jnilib libNucleotideLikelihoodCore.x86_64.jnilib -output libNucleotideLikelihoodCore.jnilib
#	lipo -create libAminoAcidLikelihoodCore.PPC.jnilib libAminoAcidLikelihoodCore.i386.jnilib libAminoAcidLikelihoodCore.x86_64.jnilib -output libAminoAcidLikelihoodCore.jnilib

libNucleotideLikelihoodCore.PPC.jnilib: NucleotideLikelihoodCore.PPC.o
	${CC} -framework JavaVM -arch ppc -dynamiclib -o libNucleotideLikelihoodCore.PPC.jnilib NucleotideLikelihoodCore.PPC.o

libNucleotideLikelihoodCore.i386.jnilib: NucleotideLikelihoodCore.i386.o
	${CC} -framework JavaVM -arch i386 -dynamiclib -o libNucleotideLikelihoodCore.i386.jnilib NucleotideLikelihoodCore.i386.o

libNucleotideLikelihoodCore.x86_64.jnilib: NucleotideLikelihoodCore.x86_64.o
	${CC} -framework JavaVM -arch x86_64 -dynamiclib -o libNucleotideLikelihoodCore.x86_64.jnilib NucleotideLikelihoodCore.x86_64.o

NucleotideLikelihoodCore.PPC.o: NucleotideLikelihoodCore.c
	${CC} ${CFLAGS_PPC} ${INCLUDES} -o NucleotideLikelihoodCore.PPC.o -c NucleotideLikelihoodCore.c

NucleotideLikelihoodCore.i386.o: NucleotideLikelihoodCore.c
	${CC} ${CFLAGS_I386} ${INCLUDES} -o NucleotideLikelihoodCore.i386.o -c NucleotideLikelihoodCore.c

NucleotideLikelihoodCore.x86_64.o: NucleotideLikelihoodCore.c
	${CC} ${CFLAGS_X86_64} ${INCLUDES} -o NucleotideLikelihoodCore.x86_64.o -c NucleotideLikelihoodCore.c

libGeneralLikelihoodCore.PPC.jnilib: GeneralLikelihoodCore.PPC.o
	${CC} -framework JavaVM -arch ppc -dynamiclib -o libGeneralLikelihoodCore.PPC.jnilib GeneralLikelihoodCore.PPC.o

libGeneralLikelihoodCore.i386.jnilib: GeneralLikelihoodCore.i386.o
	${CC} -framework JavaVM -arch i386 -dynamiclib -o libGeneralLikelihoodCore.i386.jnilib GeneralLikelihoodCore.i386.o

libGeneralLikelihoodCore.x86_64.jnilib: GeneralLikelihoodCore.x86_64.o
	${CC} -framework JavaVM -arch x86_64 -dynamiclib -o libGeneralLikelihoodCore.x86_64.jnilib GeneralLikelihoodCore.x86_64.o

GeneralLikelihoodCore.PPC.o: GeneralLikelihoodCore.c
	${CC} ${CFLAGS_PPC} ${INCLUDES} -o GeneralLikelihoodCore.PPC.o -c GeneralLikelihoodCore.c

GeneralLikelihoodCore.i386.o: GeneralLikelihoodCore.c
	${CC} ${CFLAGS_I386} ${INCLUDES} -o GeneralLikelihoodCore.i386.o -c GeneralLikelihoodCore.c

GeneralLikelihoodCore.x86_64.o: GeneralLikelihoodCore.c
	${CC} ${CFLAGS_X86_64} ${INCLUDES} -o GeneralLikelihoodCore.x86_64.o -c GeneralLikelihoodCore.c


libAminoAcidLikelihoodCore.PPC.jnilib: AminoAcidLikelihoodCore.PPC.o
	${CC} -framework JavaVM -arch ppc -dynamiclib -o libAminoAcidLikelihoodCore.PPC.jnilib AminoAcidLikelihoodCore.PPC.o

libAminoAcidLikelihoodCore.i386.jnilib: AminoAcidLikelihoodCore.i386.o
	${CC} -framework JavaVM -arch i386 -dynamiclib -o libAminoAcidLikelihoodCore.i386.jnilib AminoAcidLikelihoodCore.i386.o

libAminoAcidLikelihoodCore.x86_64.jnilib: AminoAcidLikelihoodCore.x86_64.o
	${CC} -framework JavaVM -arch x86_64 -dynamiclib -o libAminoAcidLikelihoodCore.x86_64.jnilib AminoAcidLikelihoodCore.x86_64.o

AminoAcidLikelihoodCore.PPC.o: AminoAcidLikelihoodCore.c
	${CC} ${CFLAGS_PPC} ${INCLUDES} -o AminoAcidLikelihoodCore.PPC.o -c AminoAcidLikelihoodCore.c

AminoAcidLikelihoodCore.i386.o: AminoAcidLikelihoodCore.c
	${CC} ${CFLAGS_I386} ${INCLUDES} -o AminoAcidLikelihoodCore.i386.o -c AminoAcidLikelihoodCore.c

AminoAcidLikelihoodCore.x86_64.o: AminoAcidLikelihoodCore.c
	${CC} ${CFLAGS_X86_64} ${INCLUDES} -o AminoAcidLikelihoodCore.x86_64.o -c AminoAcidLikelihoodCore.c

clean:
	/bin/rm -f *.jnilib *.o
	
