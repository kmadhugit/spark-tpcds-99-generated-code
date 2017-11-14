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
/* 021 */     boolean isNullA4;
/* 022 */     int primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull4 = i.isNullAt(7);
/* 026 */       int value4 = isNull4 ? -1 : (i.getInt(7));
/* 027 */       isNullA4 = isNull4;
/* 028 */       primitiveA4 = value4;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB4;
/* 032 */     int primitiveB4;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull4 = i.isNullAt(7);
/* 036 */       int value4 = isNull4 ? -1 : (i.getInt(7));
/* 037 */       isNullB4 = isNull4;
/* 038 */       primitiveB4 = value4;
/* 039 */     }
/* 040 */     if (isNullA4 && isNullB4) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA4) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB4) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     i = a;
/* 054 */     boolean isNullA5;
/* 055 */     int primitiveA5;
/* 056 */     {
/* 057 */
/* 058 */       boolean isNull5 = i.isNullAt(12);
/* 059 */       int value5 = isNull5 ? -1 : (i.getInt(12));
/* 060 */       isNullA5 = isNull5;
/* 061 */       primitiveA5 = value5;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB5;
/* 065 */     int primitiveB5;
/* 066 */     {
/* 067 */
/* 068 */       boolean isNull5 = i.isNullAt(12);
/* 069 */       int value5 = isNull5 ? -1 : (i.getInt(12));
/* 070 */       isNullB5 = isNull5;
/* 071 */       primitiveB5 = value5;
/* 072 */     }
/* 073 */     if (isNullA5 && isNullB5) {
/* 074 */       // Nothing
/* 075 */     } else if (isNullA5) {
/* 076 */       return -1;
/* 077 */     } else if (isNullB5) {
/* 078 */       return 1;
/* 079 */     } else {
/* 080 */       int comp = (primitiveA5 > primitiveB5 ? 1 : primitiveA5 < primitiveB5 ? -1 : 0);
/* 081 */       if (comp != 0) {
/* 082 */         return comp;
/* 083 */       }
/* 084 */     }
/* 085 */
/* 086 */     return 0;
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */
/* 091 */   private int compare_1(InternalRow a, InternalRow b) {
/* 092 */
/* 093 */     InternalRow i = null;  // Holds current row being evaluated.
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA2;
/* 097 */     UTF8String primitiveA2;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull2 = i.isNullAt(2);
/* 101 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 102 */       isNullA2 = isNull2;
/* 103 */       primitiveA2 = value2;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB2;
/* 107 */     UTF8String primitiveB2;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull2 = i.isNullAt(2);
/* 111 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 112 */       isNullB2 = isNull2;
/* 113 */       primitiveB2 = value2;
/* 114 */     }
/* 115 */     if (isNullA2 && isNullB2) {
/* 116 */       // Nothing
/* 117 */     } else if (isNullA2) {
/* 118 */       return -1;
/* 119 */     } else if (isNullB2) {
/* 120 */       return 1;
/* 121 */     } else {
/* 122 */       int comp = primitiveA2.compare(primitiveB2);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     i = a;
/* 129 */     boolean isNullA3;
/* 130 */     int primitiveA3;
/* 131 */     {
/* 132 */
/* 133 */       boolean isNull3 = i.isNullAt(17);
/* 134 */       int value3 = isNull3 ? -1 : (i.getInt(17));
/* 135 */       isNullA3 = isNull3;
/* 136 */       primitiveA3 = value3;
/* 137 */     }
/* 138 */     i = b;
/* 139 */     boolean isNullB3;
/* 140 */     int primitiveB3;
/* 141 */     {
/* 142 */
/* 143 */       boolean isNull3 = i.isNullAt(17);
/* 144 */       int value3 = isNull3 ? -1 : (i.getInt(17));
/* 145 */       isNullB3 = isNull3;
/* 146 */       primitiveB3 = value3;
/* 147 */     }
/* 148 */     if (isNullA3 && isNullB3) {
/* 149 */       // Nothing
/* 150 */     } else if (isNullA3) {
/* 151 */       return -1;
/* 152 */     } else if (isNullB3) {
/* 153 */       return 1;
/* 154 */     } else {
/* 155 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 156 */       if (comp != 0) {
/* 157 */         return comp;
/* 158 */       }
/* 159 */     }
/* 160 */
/* 161 */     return 0;
/* 162 */
/* 163 */   }
/* 164 */
/* 165 */
/* 166 */   private int compare_0(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA;
/* 172 */     UTF8String primitiveA;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull = i.isNullAt(0);
/* 176 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 177 */       isNullA = isNull;
/* 178 */       primitiveA = value;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB;
/* 182 */     UTF8String primitiveB;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull = i.isNullAt(0);
/* 186 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 187 */       isNullB = isNull;
/* 188 */       primitiveB = value;
/* 189 */     }
/* 190 */     if (isNullA && isNullB) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = primitiveA.compare(primitiveB);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     i = a;
/* 204 */     boolean isNullA1;
/* 205 */     UTF8String primitiveA1;
/* 206 */     {
/* 207 */
/* 208 */       boolean isNull1 = i.isNullAt(1);
/* 209 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 210 */       isNullA1 = isNull1;
/* 211 */       primitiveA1 = value1;
/* 212 */     }
/* 213 */     i = b;
/* 214 */     boolean isNullB1;
/* 215 */     UTF8String primitiveB1;
/* 216 */     {
/* 217 */
/* 218 */       boolean isNull1 = i.isNullAt(1);
/* 219 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 220 */       isNullB1 = isNull1;
/* 221 */       primitiveB1 = value1;
/* 222 */     }
/* 223 */     if (isNullA1 && isNullB1) {
/* 224 */       // Nothing
/* 225 */     } else if (isNullA1) {
/* 226 */       return -1;
/* 227 */     } else if (isNullB1) {
/* 228 */       return 1;
/* 229 */     } else {
/* 230 */       int comp = primitiveA1.compare(primitiveB1);
/* 231 */       if (comp != 0) {
/* 232 */         return comp;
/* 233 */       }
/* 234 */     }
/* 235 */
/* 236 */     return 0;
/* 237 */
/* 238 */   }
/* 239 */
/* 240 */
/* 241 */   public int compare(InternalRow a, InternalRow b) {
/* 242 */
/* 243 */     InternalRow i = null;
/* 244 */
/* 245 */     int comp = compare_0(a, b);
/* 246 */     if (comp != 0) {
/* 247 */       return comp;
/* 248 */     }
/* 249 */
/* 250 */     int comp1 = compare_1(a, b);
/* 251 */     if (comp1 != 0) {
/* 252 */       return comp1;
/* 253 */     }
/* 254 */
/* 255 */     int comp2 = compare_2(a, b);
/* 256 */     if (comp2 != 0) {
/* 257 */       return comp2;
/* 258 */     }
/* 259 */
/* 260 */
/* 261 */     return 0;
/* 262 */   }
/* 263 */ }
