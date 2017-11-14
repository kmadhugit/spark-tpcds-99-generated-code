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
/* 025 */       UTF8String value = i.getUTF8String(0);
/* 026 */       isNullA = false;
/* 027 */       primitiveA = value;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB;
/* 031 */     UTF8String primitiveB;
/* 032 */     {
/* 033 */
/* 034 */       UTF8String value = i.getUTF8String(0);
/* 035 */       isNullB = false;
/* 036 */       primitiveB = value;
/* 037 */     }
/* 038 */     if (isNullA && isNullB) {
/* 039 */       // Nothing
/* 040 */     } else if (isNullA) {
/* 041 */       return -1;
/* 042 */     } else if (isNullB) {
/* 043 */       return 1;
/* 044 */     } else {
/* 045 */       int comp = primitiveA.compare(primitiveB);
/* 046 */       if (comp != 0) {
/* 047 */         return comp;
/* 048 */       }
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     i = a;
/* 053 */     boolean isNullA1;
/* 054 */     int primitiveA1;
/* 055 */     {
/* 056 */
/* 057 */       boolean isNull1 = i.isNullAt(1);
/* 058 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 059 */       isNullA1 = isNull1;
/* 060 */       primitiveA1 = value1;
/* 061 */     }
/* 062 */     i = b;
/* 063 */     boolean isNullB1;
/* 064 */     int primitiveB1;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull1 = i.isNullAt(1);
/* 068 */       int value1 = isNull1 ? -1 : (i.getInt(1));
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
/* 079 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 080 */       if (comp != 0) {
/* 081 */         return comp;
/* 082 */       }
/* 083 */     }
/* 084 */
/* 085 */
/* 086 */     i = a;
/* 087 */     boolean isNullA2;
/* 088 */     int primitiveA2;
/* 089 */     {
/* 090 */
/* 091 */       boolean isNull2 = i.isNullAt(2);
/* 092 */       int value2 = isNull2 ? -1 : (i.getInt(2));
/* 093 */       isNullA2 = isNull2;
/* 094 */       primitiveA2 = value2;
/* 095 */     }
/* 096 */     i = b;
/* 097 */     boolean isNullB2;
/* 098 */     int primitiveB2;
/* 099 */     {
/* 100 */
/* 101 */       boolean isNull2 = i.isNullAt(2);
/* 102 */       int value2 = isNull2 ? -1 : (i.getInt(2));
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
/* 113 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
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
/* 125 */       boolean isNull3 = i.isNullAt(3);
/* 126 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 127 */       isNullA3 = isNull3;
/* 128 */       primitiveA3 = value3;
/* 129 */     }
/* 130 */     i = b;
/* 131 */     boolean isNullB3;
/* 132 */     int primitiveB3;
/* 133 */     {
/* 134 */
/* 135 */       boolean isNull3 = i.isNullAt(3);
/* 136 */       int value3 = isNull3 ? -1 : (i.getInt(3));
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
/* 153 */
/* 154 */     i = a;
/* 155 */     boolean isNullA4;
/* 156 */     UTF8String primitiveA4;
/* 157 */     {
/* 158 */
/* 159 */       boolean isNull4 = i.isNullAt(4);
/* 160 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 161 */       isNullA4 = isNull4;
/* 162 */       primitiveA4 = value4;
/* 163 */     }
/* 164 */     i = b;
/* 165 */     boolean isNullB4;
/* 166 */     UTF8String primitiveB4;
/* 167 */     {
/* 168 */
/* 169 */       boolean isNull4 = i.isNullAt(4);
/* 170 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 171 */       isNullB4 = isNull4;
/* 172 */       primitiveB4 = value4;
/* 173 */     }
/* 174 */     if (isNullA4 && isNullB4) {
/* 175 */       // Nothing
/* 176 */     } else if (isNullA4) {
/* 177 */       return -1;
/* 178 */     } else if (isNullB4) {
/* 179 */       return 1;
/* 180 */     } else {
/* 181 */       int comp = primitiveA4.compare(primitiveB4);
/* 182 */       if (comp != 0) {
/* 183 */         return comp;
/* 184 */       }
/* 185 */     }
/* 186 */
/* 187 */     return 0;
/* 188 */   }
/* 189 */ }
