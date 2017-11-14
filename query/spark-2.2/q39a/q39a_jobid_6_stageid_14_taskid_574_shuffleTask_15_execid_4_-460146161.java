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
/* 022 */     double primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull4 = i.isNullAt(4);
/* 026 */       double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 027 */       isNullA4 = isNull4;
/* 028 */       primitiveA4 = value4;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB4;
/* 032 */     double primitiveB4;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull4 = i.isNullAt(4);
/* 036 */       double value4 = isNull4 ? -1.0 : (i.getDouble(4));
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
/* 047 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA4, primitiveB4);
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
/* 058 */       boolean isNull5 = i.isNullAt(7);
/* 059 */       int value5 = isNull5 ? -1 : (i.getInt(7));
/* 060 */       isNullA5 = isNull5;
/* 061 */       primitiveA5 = value5;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB5;
/* 065 */     int primitiveB5;
/* 066 */     {
/* 067 */
/* 068 */       boolean isNull5 = i.isNullAt(7);
/* 069 */       int value5 = isNull5 ? -1 : (i.getInt(7));
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
/* 097 */     int primitiveA2;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull2 = i.isNullAt(2);
/* 101 */       int value2 = isNull2 ? -1 : (i.getInt(2));
/* 102 */       isNullA2 = isNull2;
/* 103 */       primitiveA2 = value2;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB2;
/* 107 */     int primitiveB2;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull2 = i.isNullAt(2);
/* 111 */       int value2 = isNull2 ? -1 : (i.getInt(2));
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
/* 122 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     i = a;
/* 129 */     boolean isNullA3;
/* 130 */     double primitiveA3;
/* 131 */     {
/* 132 */
/* 133 */       boolean isNull3 = i.isNullAt(3);
/* 134 */       double value3 = isNull3 ? -1.0 : (i.getDouble(3));
/* 135 */       isNullA3 = isNull3;
/* 136 */       primitiveA3 = value3;
/* 137 */     }
/* 138 */     i = b;
/* 139 */     boolean isNullB3;
/* 140 */     double primitiveB3;
/* 141 */     {
/* 142 */
/* 143 */       boolean isNull3 = i.isNullAt(3);
/* 144 */       double value3 = isNull3 ? -1.0 : (i.getDouble(3));
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
/* 155 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA3, primitiveB3);
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
/* 166 */   private int compare_3(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA6;
/* 172 */     double primitiveA6;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull6 = i.isNullAt(8);
/* 176 */       double value6 = isNull6 ? -1.0 : (i.getDouble(8));
/* 177 */       isNullA6 = isNull6;
/* 178 */       primitiveA6 = value6;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB6;
/* 182 */     double primitiveB6;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull6 = i.isNullAt(8);
/* 186 */       double value6 = isNull6 ? -1.0 : (i.getDouble(8));
/* 187 */       isNullB6 = isNull6;
/* 188 */       primitiveB6 = value6;
/* 189 */     }
/* 190 */     if (isNullA6 && isNullB6) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA6) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB6) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA6, primitiveB6);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     i = a;
/* 204 */     boolean isNullA7;
/* 205 */     double primitiveA7;
/* 206 */     {
/* 207 */
/* 208 */       boolean isNull7 = i.isNullAt(9);
/* 209 */       double value7 = isNull7 ? -1.0 : (i.getDouble(9));
/* 210 */       isNullA7 = isNull7;
/* 211 */       primitiveA7 = value7;
/* 212 */     }
/* 213 */     i = b;
/* 214 */     boolean isNullB7;
/* 215 */     double primitiveB7;
/* 216 */     {
/* 217 */
/* 218 */       boolean isNull7 = i.isNullAt(9);
/* 219 */       double value7 = isNull7 ? -1.0 : (i.getDouble(9));
/* 220 */       isNullB7 = isNull7;
/* 221 */       primitiveB7 = value7;
/* 222 */     }
/* 223 */     if (isNullA7 && isNullB7) {
/* 224 */       // Nothing
/* 225 */     } else if (isNullA7) {
/* 226 */       return -1;
/* 227 */     } else if (isNullB7) {
/* 228 */       return 1;
/* 229 */     } else {
/* 230 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA7, primitiveB7);
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
/* 241 */   private int compare_0(InternalRow a, InternalRow b) {
/* 242 */
/* 243 */     InternalRow i = null;  // Holds current row being evaluated.
/* 244 */
/* 245 */     i = a;
/* 246 */     boolean isNullA;
/* 247 */     int primitiveA;
/* 248 */     {
/* 249 */
/* 250 */       boolean isNull = i.isNullAt(0);
/* 251 */       int value = isNull ? -1 : (i.getInt(0));
/* 252 */       isNullA = isNull;
/* 253 */       primitiveA = value;
/* 254 */     }
/* 255 */     i = b;
/* 256 */     boolean isNullB;
/* 257 */     int primitiveB;
/* 258 */     {
/* 259 */
/* 260 */       boolean isNull = i.isNullAt(0);
/* 261 */       int value = isNull ? -1 : (i.getInt(0));
/* 262 */       isNullB = isNull;
/* 263 */       primitiveB = value;
/* 264 */     }
/* 265 */     if (isNullA && isNullB) {
/* 266 */       // Nothing
/* 267 */     } else if (isNullA) {
/* 268 */       return -1;
/* 269 */     } else if (isNullB) {
/* 270 */       return 1;
/* 271 */     } else {
/* 272 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 273 */       if (comp != 0) {
/* 274 */         return comp;
/* 275 */       }
/* 276 */     }
/* 277 */
/* 278 */     i = a;
/* 279 */     boolean isNullA1;
/* 280 */     int primitiveA1;
/* 281 */     {
/* 282 */
/* 283 */       boolean isNull1 = i.isNullAt(1);
/* 284 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 285 */       isNullA1 = isNull1;
/* 286 */       primitiveA1 = value1;
/* 287 */     }
/* 288 */     i = b;
/* 289 */     boolean isNullB1;
/* 290 */     int primitiveB1;
/* 291 */     {
/* 292 */
/* 293 */       boolean isNull1 = i.isNullAt(1);
/* 294 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 295 */       isNullB1 = isNull1;
/* 296 */       primitiveB1 = value1;
/* 297 */     }
/* 298 */     if (isNullA1 && isNullB1) {
/* 299 */       // Nothing
/* 300 */     } else if (isNullA1) {
/* 301 */       return -1;
/* 302 */     } else if (isNullB1) {
/* 303 */       return 1;
/* 304 */     } else {
/* 305 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 306 */       if (comp != 0) {
/* 307 */         return comp;
/* 308 */       }
/* 309 */     }
/* 310 */
/* 311 */     return 0;
/* 312 */
/* 313 */   }
/* 314 */
/* 315 */
/* 316 */   public int compare(InternalRow a, InternalRow b) {
/* 317 */
/* 318 */     InternalRow i = null;
/* 319 */
/* 320 */     int comp = compare_0(a, b);
/* 321 */     if (comp != 0) {
/* 322 */       return comp;
/* 323 */     }
/* 324 */
/* 325 */     int comp1 = compare_1(a, b);
/* 326 */     if (comp1 != 0) {
/* 327 */       return comp1;
/* 328 */     }
/* 329 */
/* 330 */     int comp2 = compare_2(a, b);
/* 331 */     if (comp2 != 0) {
/* 332 */       return comp2;
/* 333 */     }
/* 334 */
/* 335 */     int comp3 = compare_3(a, b);
/* 336 */     if (comp3 != 0) {
/* 337 */       return comp3;
/* 338 */     }
/* 339 */
/* 340 */
/* 341 */     return 0;
/* 342 */   }
/* 343 */ }
