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
/* 022 */     byte primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       byte value = i.getByte(3);
/* 026 */       isNullA = false;
/* 027 */       primitiveA = value;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB;
/* 031 */     byte primitiveB;
/* 032 */     {
/* 033 */
/* 034 */       byte value = i.getByte(3);
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
/* 057 */       boolean isNull1 = true;
/* 058 */       UTF8String value1 = null;
/* 059 */
/* 060 */
/* 061 */       boolean isNull2 = false;
/* 062 */
/* 063 */       byte value4 = i.getByte(3);
/* 064 */       boolean isNull3 = false;
/* 065 */       int value3 = -1;
/* 066 */       if (!false) {
/* 067 */         value3 = (int) value4;
/* 068 */       }
/* 069 */
/* 070 */       boolean value2 = false;
/* 071 */       value2 = value3 == 0;
/* 072 */       if (!false && value2) {
/* 073 */
/* 074 */         boolean isNull6 = i.isNullAt(1);
/* 075 */         UTF8String value6 = isNull6 ? null : (i.getUTF8String(1));
/* 076 */         isNull1 = isNull6;
/* 077 */         value1 = value6;
/* 078 */       }
/* 079 */
/* 080 */       else {
/* 081 */       }
/* 082 */       isNullA1 = isNull1;
/* 083 */       primitiveA1 = value1;
/* 084 */     }
/* 085 */     i = b;
/* 086 */     boolean isNullB1;
/* 087 */     UTF8String primitiveB1;
/* 088 */     {
/* 089 */
/* 090 */       boolean isNull1 = true;
/* 091 */       UTF8String value1 = null;
/* 092 */
/* 093 */
/* 094 */       boolean isNull2 = false;
/* 095 */
/* 096 */       byte value4 = i.getByte(3);
/* 097 */       boolean isNull3 = false;
/* 098 */       int value3 = -1;
/* 099 */       if (!false) {
/* 100 */         value3 = (int) value4;
/* 101 */       }
/* 102 */
/* 103 */       boolean value2 = false;
/* 104 */       value2 = value3 == 0;
/* 105 */       if (!false && value2) {
/* 106 */
/* 107 */         boolean isNull6 = i.isNullAt(1);
/* 108 */         UTF8String value6 = isNull6 ? null : (i.getUTF8String(1));
/* 109 */         isNull1 = isNull6;
/* 110 */         value1 = value6;
/* 111 */       }
/* 112 */
/* 113 */       else {
/* 114 */       }
/* 115 */       isNullB1 = isNull1;
/* 116 */       primitiveB1 = value1;
/* 117 */     }
/* 118 */     if (isNullA1 && isNullB1) {
/* 119 */       // Nothing
/* 120 */     } else if (isNullA1) {
/* 121 */       return -1;
/* 122 */     } else if (isNullB1) {
/* 123 */       return 1;
/* 124 */     } else {
/* 125 */       int comp = primitiveA1.compare(primitiveB1);
/* 126 */       if (comp != 0) {
/* 127 */         return comp;
/* 128 */       }
/* 129 */     }
/* 130 */
/* 131 */
/* 132 */     i = a;
/* 133 */     boolean isNullA2;
/* 134 */     int primitiveA2;
/* 135 */     {
/* 136 */
/* 137 */       boolean isNull7 = i.isNullAt(4);
/* 138 */       int value7 = isNull7 ? -1 : (i.getInt(4));
/* 139 */       isNullA2 = isNull7;
/* 140 */       primitiveA2 = value7;
/* 141 */     }
/* 142 */     i = b;
/* 143 */     boolean isNullB2;
/* 144 */     int primitiveB2;
/* 145 */     {
/* 146 */
/* 147 */       boolean isNull7 = i.isNullAt(4);
/* 148 */       int value7 = isNull7 ? -1 : (i.getInt(4));
/* 149 */       isNullB2 = isNull7;
/* 150 */       primitiveB2 = value7;
/* 151 */     }
/* 152 */     if (isNullA2 && isNullB2) {
/* 153 */       // Nothing
/* 154 */     } else if (isNullA2) {
/* 155 */       return -1;
/* 156 */     } else if (isNullB2) {
/* 157 */       return 1;
/* 158 */     } else {
/* 159 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
/* 160 */       if (comp != 0) {
/* 161 */         return comp;
/* 162 */       }
/* 163 */     }
/* 164 */
/* 165 */     return 0;
/* 166 */   }
/* 167 */ }
