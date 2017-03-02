/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */
/* 017 */   public int compare(InternalRow a, InternalRow b) {
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA;
/* 022 */     UTF8String primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(0);
/* 026 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     UTF8String primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(0);
/* 036 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 037 */       isNullB = isNull;
/* 038 */       primitiveB = value;
/* 039 */     }
/* 040 */     if (isNullA && isNullB) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = primitiveA.compare(primitiveB);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     UTF8String primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = i.isNullAt(1);
/* 060 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 061 */       isNullA1 = isNull1;
/* 062 */       primitiveA1 = value1;
/* 063 */     }
/* 064 */     i = b;
/* 065 */     boolean isNullB1;
/* 066 */     UTF8String primitiveB1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull1 = i.isNullAt(1);
/* 070 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 071 */       isNullB1 = isNull1;
/* 072 */       primitiveB1 = value1;
/* 073 */     }
/* 074 */     if (isNullA1 && isNullB1) {
/* 075 */       // Nothing
/* 076 */     } else if (isNullA1) {
/* 077 */       return -1;
/* 078 */     } else if (isNullB1) {
/* 079 */       return 1;
/* 080 */     } else {
/* 081 */       int comp = primitiveA1.compare(primitiveB1);
/* 082 */       if (comp != 0) {
/* 083 */         return comp;
/* 084 */       }
/* 085 */     }
/* 086 */
/* 087 */
/* 088 */     i = a;
/* 089 */     boolean isNullA2;
/* 090 */     UTF8String primitiveA2;
/* 091 */     {
/* 092 */
/* 093 */       boolean isNull2 = i.isNullAt(2);
/* 094 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 095 */       isNullA2 = isNull2;
/* 096 */       primitiveA2 = value2;
/* 097 */     }
/* 098 */     i = b;
/* 099 */     boolean isNullB2;
/* 100 */     UTF8String primitiveB2;
/* 101 */     {
/* 102 */
/* 103 */       boolean isNull2 = i.isNullAt(2);
/* 104 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 105 */       isNullB2 = isNull2;
/* 106 */       primitiveB2 = value2;
/* 107 */     }
/* 108 */     if (isNullA2 && isNullB2) {
/* 109 */       // Nothing
/* 110 */     } else if (isNullA2) {
/* 111 */       return -1;
/* 112 */     } else if (isNullB2) {
/* 113 */       return 1;
/* 114 */     } else {
/* 115 */       int comp = primitiveA2.compare(primitiveB2);
/* 116 */       if (comp != 0) {
/* 117 */         return comp;
/* 118 */       }
/* 119 */     }
/* 120 */
/* 121 */
/* 122 */     i = a;
/* 123 */     boolean isNullA3;
/* 124 */     int primitiveA3;
/* 125 */     {
/* 126 */
/* 127 */       int value3 = i.getInt(7);
/* 128 */       isNullA3 = false;
/* 129 */       primitiveA3 = value3;
/* 130 */     }
/* 131 */     i = b;
/* 132 */     boolean isNullB3;
/* 133 */     int primitiveB3;
/* 134 */     {
/* 135 */
/* 136 */       int value3 = i.getInt(7);
/* 137 */       isNullB3 = false;
/* 138 */       primitiveB3 = value3;
/* 139 */     }
/* 140 */     if (isNullA3 && isNullB3) {
/* 141 */       // Nothing
/* 142 */     } else if (isNullA3) {
/* 143 */       return -1;
/* 144 */     } else if (isNullB3) {
/* 145 */       return 1;
/* 146 */     } else {
/* 147 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 148 */       if (comp != 0) {
/* 149 */         return comp;
/* 150 */       }
/* 151 */     }
/* 152 */
/* 153 */     return 0;
/* 154 */   }
/* 155 */ }
