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
/* 127 */       boolean isNull3 = i.isNullAt(4);
/* 128 */       int value3 = isNull3 ? -1 : (i.getInt(4));
/* 129 */       isNullA3 = isNull3;
/* 130 */       primitiveA3 = value3;
/* 131 */     }
/* 132 */     i = b;
/* 133 */     boolean isNullB3;
/* 134 */     int primitiveB3;
/* 135 */     {
/* 136 */
/* 137 */       boolean isNull3 = i.isNullAt(4);
/* 138 */       int value3 = isNull3 ? -1 : (i.getInt(4));
/* 139 */       isNullB3 = isNull3;
/* 140 */       primitiveB3 = value3;
/* 141 */     }
/* 142 */     if (isNullA3 && isNullB3) {
/* 143 */       // Nothing
/* 144 */     } else if (isNullA3) {
/* 145 */       return -1;
/* 146 */     } else if (isNullB3) {
/* 147 */       return 1;
/* 148 */     } else {
/* 149 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 150 */       if (comp != 0) {
/* 151 */         return comp;
/* 152 */       }
/* 153 */     }
/* 154 */
/* 155 */
/* 156 */     i = a;
/* 157 */     boolean isNullA4;
/* 158 */     UTF8String primitiveA4;
/* 159 */     {
/* 160 */
/* 161 */       boolean isNull4 = i.isNullAt(6);
/* 162 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(6));
/* 163 */       isNullA4 = isNull4;
/* 164 */       primitiveA4 = value4;
/* 165 */     }
/* 166 */     i = b;
/* 167 */     boolean isNullB4;
/* 168 */     UTF8String primitiveB4;
/* 169 */     {
/* 170 */
/* 171 */       boolean isNull4 = i.isNullAt(6);
/* 172 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(6));
/* 173 */       isNullB4 = isNull4;
/* 174 */       primitiveB4 = value4;
/* 175 */     }
/* 176 */     if (isNullA4 && isNullB4) {
/* 177 */       // Nothing
/* 178 */     } else if (isNullA4) {
/* 179 */       return -1;
/* 180 */     } else if (isNullB4) {
/* 181 */       return 1;
/* 182 */     } else {
/* 183 */       int comp = primitiveA4.compare(primitiveB4);
/* 184 */       if (comp != 0) {
/* 185 */         return comp;
/* 186 */       }
/* 187 */     }
/* 188 */
/* 189 */
/* 190 */     i = a;
/* 191 */     boolean isNullA5;
/* 192 */     int primitiveA5;
/* 193 */     {
/* 194 */
/* 195 */       boolean isNull5 = i.isNullAt(8);
/* 196 */       int value5 = isNull5 ? -1 : (i.getInt(8));
/* 197 */       isNullA5 = isNull5;
/* 198 */       primitiveA5 = value5;
/* 199 */     }
/* 200 */     i = b;
/* 201 */     boolean isNullB5;
/* 202 */     int primitiveB5;
/* 203 */     {
/* 204 */
/* 205 */       boolean isNull5 = i.isNullAt(8);
/* 206 */       int value5 = isNull5 ? -1 : (i.getInt(8));
/* 207 */       isNullB5 = isNull5;
/* 208 */       primitiveB5 = value5;
/* 209 */     }
/* 210 */     if (isNullA5 && isNullB5) {
/* 211 */       // Nothing
/* 212 */     } else if (isNullA5) {
/* 213 */       return -1;
/* 214 */     } else if (isNullB5) {
/* 215 */       return 1;
/* 216 */     } else {
/* 217 */       int comp = (primitiveA5 > primitiveB5 ? 1 : primitiveA5 < primitiveB5 ? -1 : 0);
/* 218 */       if (comp != 0) {
/* 219 */         return comp;
/* 220 */       }
/* 221 */     }
/* 222 */
/* 223 */
/* 224 */     i = a;
/* 225 */     boolean isNullA6;
/* 226 */     int primitiveA6;
/* 227 */     {
/* 228 */
/* 229 */       boolean isNull6 = i.isNullAt(10);
/* 230 */       int value6 = isNull6 ? -1 : (i.getInt(10));
/* 231 */       isNullA6 = isNull6;
/* 232 */       primitiveA6 = value6;
/* 233 */     }
/* 234 */     i = b;
/* 235 */     boolean isNullB6;
/* 236 */     int primitiveB6;
/* 237 */     {
/* 238 */
/* 239 */       boolean isNull6 = i.isNullAt(10);
/* 240 */       int value6 = isNull6 ? -1 : (i.getInt(10));
/* 241 */       isNullB6 = isNull6;
/* 242 */       primitiveB6 = value6;
/* 243 */     }
/* 244 */     if (isNullA6 && isNullB6) {
/* 245 */       // Nothing
/* 246 */     } else if (isNullA6) {
/* 247 */       return -1;
/* 248 */     } else if (isNullB6) {
/* 249 */       return 1;
/* 250 */     } else {
/* 251 */       int comp = (primitiveA6 > primitiveB6 ? 1 : primitiveA6 < primitiveB6 ? -1 : 0);
/* 252 */       if (comp != 0) {
/* 253 */         return comp;
/* 254 */       }
/* 255 */     }
/* 256 */
/* 257 */
/* 258 */     i = a;
/* 259 */     boolean isNullA7;
/* 260 */     int primitiveA7;
/* 261 */     {
/* 262 */
/* 263 */       boolean isNull7 = i.isNullAt(12);
/* 264 */       int value7 = isNull7 ? -1 : (i.getInt(12));
/* 265 */       isNullA7 = isNull7;
/* 266 */       primitiveA7 = value7;
/* 267 */     }
/* 268 */     i = b;
/* 269 */     boolean isNullB7;
/* 270 */     int primitiveB7;
/* 271 */     {
/* 272 */
/* 273 */       boolean isNull7 = i.isNullAt(12);
/* 274 */       int value7 = isNull7 ? -1 : (i.getInt(12));
/* 275 */       isNullB7 = isNull7;
/* 276 */       primitiveB7 = value7;
/* 277 */     }
/* 278 */     if (isNullA7 && isNullB7) {
/* 279 */       // Nothing
/* 280 */     } else if (isNullA7) {
/* 281 */       return -1;
/* 282 */     } else if (isNullB7) {
/* 283 */       return 1;
/* 284 */     } else {
/* 285 */       int comp = (primitiveA7 > primitiveB7 ? 1 : primitiveA7 < primitiveB7 ? -1 : 0);
/* 286 */       if (comp != 0) {
/* 287 */         return comp;
/* 288 */       }
/* 289 */     }
/* 290 */
/* 291 */     return 0;
/* 292 */   }
/* 293 */ }
