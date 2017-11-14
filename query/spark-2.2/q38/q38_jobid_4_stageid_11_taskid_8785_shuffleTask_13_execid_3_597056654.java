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
/* 016 */   private int compare_2(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA2;
/* 022 */     UTF8String primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull7 = i.isNullAt(2);
/* 026 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(2));
/* 027 */       boolean isNull6 = isNull7;
/* 028 */       UTF8String value6 = value7;
/* 029 */       if (isNull6) {
/* 030 */
/* 031 */         if (!false) {
/* 032 */           isNull6 = false;
/* 033 */           value6 = ((UTF8String) references[2]);
/* 034 */         }
/* 035 */       }
/* 036 */       isNullA2 = isNull6;
/* 037 */       primitiveA2 = value6;
/* 038 */     }
/* 039 */     i = b;
/* 040 */     boolean isNullB2;
/* 041 */     UTF8String primitiveB2;
/* 042 */     {
/* 043 */
/* 044 */       boolean isNull7 = i.isNullAt(2);
/* 045 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(2));
/* 046 */       boolean isNull6 = isNull7;
/* 047 */       UTF8String value6 = value7;
/* 048 */       if (isNull6) {
/* 049 */
/* 050 */         if (!false) {
/* 051 */           isNull6 = false;
/* 052 */           value6 = ((UTF8String) references[2]);
/* 053 */         }
/* 054 */       }
/* 055 */       isNullB2 = isNull6;
/* 056 */       primitiveB2 = value6;
/* 057 */     }
/* 058 */     if (isNullA2 && isNullB2) {
/* 059 */       // Nothing
/* 060 */     } else if (isNullA2) {
/* 061 */       return -1;
/* 062 */     } else if (isNullB2) {
/* 063 */       return 1;
/* 064 */     } else {
/* 065 */       int comp = primitiveA2.compare(primitiveB2);
/* 066 */       if (comp != 0) {
/* 067 */         return comp;
/* 068 */       }
/* 069 */     }
/* 070 */
/* 071 */     return 0;
/* 072 */
/* 073 */   }
/* 074 */
/* 075 */
/* 076 */   private int compare_1(InternalRow a, InternalRow b) {
/* 077 */
/* 078 */     InternalRow i = null;  // Holds current row being evaluated.
/* 079 */
/* 080 */     i = a;
/* 081 */     boolean isNullA1;
/* 082 */     UTF8String primitiveA1;
/* 083 */     {
/* 084 */
/* 085 */       boolean isNull4 = i.isNullAt(1);
/* 086 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 087 */       boolean isNull3 = isNull4;
/* 088 */       UTF8String value3 = value4;
/* 089 */       if (isNull3) {
/* 090 */
/* 091 */         if (!false) {
/* 092 */           isNull3 = false;
/* 093 */           value3 = ((UTF8String) references[1]);
/* 094 */         }
/* 095 */       }
/* 096 */       isNullA1 = isNull3;
/* 097 */       primitiveA1 = value3;
/* 098 */     }
/* 099 */     i = b;
/* 100 */     boolean isNullB1;
/* 101 */     UTF8String primitiveB1;
/* 102 */     {
/* 103 */
/* 104 */       boolean isNull4 = i.isNullAt(1);
/* 105 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 106 */       boolean isNull3 = isNull4;
/* 107 */       UTF8String value3 = value4;
/* 108 */       if (isNull3) {
/* 109 */
/* 110 */         if (!false) {
/* 111 */           isNull3 = false;
/* 112 */           value3 = ((UTF8String) references[1]);
/* 113 */         }
/* 114 */       }
/* 115 */       isNullB1 = isNull3;
/* 116 */       primitiveB1 = value3;
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
/* 131 */     return 0;
/* 132 */
/* 133 */   }
/* 134 */
/* 135 */
/* 136 */   private int compare_0(InternalRow a, InternalRow b) {
/* 137 */
/* 138 */     InternalRow i = null;  // Holds current row being evaluated.
/* 139 */
/* 140 */     i = a;
/* 141 */     boolean isNullA;
/* 142 */     UTF8String primitiveA;
/* 143 */     {
/* 144 */
/* 145 */       boolean isNull1 = i.isNullAt(0);
/* 146 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 147 */       boolean isNull = isNull1;
/* 148 */       UTF8String value = value1;
/* 149 */       if (isNull) {
/* 150 */
/* 151 */         if (!false) {
/* 152 */           isNull = false;
/* 153 */           value = ((UTF8String) references[0]);
/* 154 */         }
/* 155 */       }
/* 156 */       isNullA = isNull;
/* 157 */       primitiveA = value;
/* 158 */     }
/* 159 */     i = b;
/* 160 */     boolean isNullB;
/* 161 */     UTF8String primitiveB;
/* 162 */     {
/* 163 */
/* 164 */       boolean isNull1 = i.isNullAt(0);
/* 165 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 166 */       boolean isNull = isNull1;
/* 167 */       UTF8String value = value1;
/* 168 */       if (isNull) {
/* 169 */
/* 170 */         if (!false) {
/* 171 */           isNull = false;
/* 172 */           value = ((UTF8String) references[0]);
/* 173 */         }
/* 174 */       }
/* 175 */       isNullB = isNull;
/* 176 */       primitiveB = value;
/* 177 */     }
/* 178 */     if (isNullA && isNullB) {
/* 179 */       // Nothing
/* 180 */     } else if (isNullA) {
/* 181 */       return -1;
/* 182 */     } else if (isNullB) {
/* 183 */       return 1;
/* 184 */     } else {
/* 185 */       int comp = primitiveA.compare(primitiveB);
/* 186 */       if (comp != 0) {
/* 187 */         return comp;
/* 188 */       }
/* 189 */     }
/* 190 */
/* 191 */     return 0;
/* 192 */
/* 193 */   }
/* 194 */
/* 195 */
/* 196 */   public int compare(InternalRow a, InternalRow b) {
/* 197 */
/* 198 */     InternalRow i = null;
/* 199 */
/* 200 */     int comp = compare_0(a, b);
/* 201 */     if (comp != 0) {
/* 202 */       return comp;
/* 203 */     }
/* 204 */
/* 205 */     int comp1 = compare_1(a, b);
/* 206 */     if (comp1 != 0) {
/* 207 */       return comp1;
/* 208 */     }
/* 209 */
/* 210 */     int comp2 = compare_2(a, b);
/* 211 */     if (comp2 != 0) {
/* 212 */       return comp2;
/* 213 */     }
/* 214 */
/* 215 */
/* 216 */     return 0;
/* 217 */   }
/* 218 */ }
