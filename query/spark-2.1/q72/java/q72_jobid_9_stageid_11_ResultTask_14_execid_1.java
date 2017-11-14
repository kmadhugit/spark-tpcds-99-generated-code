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
/* 022 */     long primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       long value = i.getLong(5);
/* 026 */       isNullA = false;
/* 027 */       primitiveA = value;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB;
/* 031 */     long primitiveB;
/* 032 */     {
/* 033 */
/* 034 */       long value = i.getLong(5);
/* 035 */       isNullB = false;
/* 036 */       primitiveB = value;
/* 037 */     }
/* 038 */     if (isNullA && isNullB) {
/* 039 */       // Nothing
/* 040 */     } else if (isNullA) {
/* 041 */       return 1;
/* 042 */     } else if (isNullB) {
/* 043 */       return -1;
/* 044 */     } else {
/* 045 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 046 */       if (comp != 0) {
/* 047 */         return -comp;
/* 048 */       }
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     i = a;
/* 053 */     boolean isNullA1;
/* 054 */     UTF8String primitiveA1;
/* 055 */     {
/* 056 */
/* 057 */       boolean isNull1 = i.isNullAt(0);
/* 058 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 059 */       isNullA1 = isNull1;
/* 060 */       primitiveA1 = value1;
/* 061 */     }
/* 062 */     i = b;
/* 063 */     boolean isNullB1;
/* 064 */     UTF8String primitiveB1;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull1 = i.isNullAt(0);
/* 068 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 069 */       isNullB1 = isNull1;
/* 070 */       primitiveB1 = value1;
/* 071 */     }
/* 072 */     if (isNullA1 && isNullB1) {
/* 073 */       // Nothing
/* 074 */     } else if (isNullA1) {
/* 075 */       return -1;
/* 076 */     } else if (isNullB1) {
/* 077 */       return 1;
/* 078 */     } else {
/* 079 */       int comp = primitiveA1.compare(primitiveB1);
/* 080 */       if (comp != 0) {
/* 081 */         return comp;
/* 082 */       }
/* 083 */     }
/* 084 */
/* 085 */
/* 086 */     i = a;
/* 087 */     boolean isNullA2;
/* 088 */     UTF8String primitiveA2;
/* 089 */     {
/* 090 */
/* 091 */       boolean isNull2 = i.isNullAt(1);
/* 092 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 093 */       isNullA2 = isNull2;
/* 094 */       primitiveA2 = value2;
/* 095 */     }
/* 096 */     i = b;
/* 097 */     boolean isNullB2;
/* 098 */     UTF8String primitiveB2;
/* 099 */     {
/* 100 */
/* 101 */       boolean isNull2 = i.isNullAt(1);
/* 102 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(1));
/* 103 */       isNullB2 = isNull2;
/* 104 */       primitiveB2 = value2;
/* 105 */     }
/* 106 */     if (isNullA2 && isNullB2) {
/* 107 */       // Nothing
/* 108 */     } else if (isNullA2) {
/* 109 */       return -1;
/* 110 */     } else if (isNullB2) {
/* 111 */       return 1;
/* 112 */     } else {
/* 113 */       int comp = primitiveA2.compare(primitiveB2);
/* 114 */       if (comp != 0) {
/* 115 */         return comp;
/* 116 */       }
/* 117 */     }
/* 118 */
/* 119 */
/* 120 */     i = a;
/* 121 */     boolean isNullA3;
/* 122 */     int primitiveA3;
/* 123 */     {
/* 124 */
/* 125 */       boolean isNull3 = i.isNullAt(2);
/* 126 */       int value3 = isNull3 ? -1 : (i.getInt(2));
/* 127 */       isNullA3 = isNull3;
/* 128 */       primitiveA3 = value3;
/* 129 */     }
/* 130 */     i = b;
/* 131 */     boolean isNullB3;
/* 132 */     int primitiveB3;
/* 133 */     {
/* 134 */
/* 135 */       boolean isNull3 = i.isNullAt(2);
/* 136 */       int value3 = isNull3 ? -1 : (i.getInt(2));
/* 137 */       isNullB3 = isNull3;
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
