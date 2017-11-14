/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull18 = i.isNullAt(8);
/* 028 */     UTF8String value18 = isNull18 ? null : (i.getUTF8String(8));
/* 029 */     boolean isNull17 = true;
/* 030 */     java.lang.String value17 = null;
/* 031 */     if (!isNull18) {
/* 032 */
/* 033 */       isNull17 = false;
/* 034 */       if (!isNull17) {
/* 035 */
/* 036 */         Object funcResult8 = null;
/* 037 */         funcResult8 = value18.toString();
/* 038 */         value17 = (java.lang.String) funcResult8;
/* 039 */
/* 040 */       }
/* 041 */     }
/* 042 */     if (isNull17) {
/* 043 */       values[8] = null;
/* 044 */     } else {
/* 045 */       values[8] = value17;
/* 046 */     }
/* 047 */
/* 048 */     boolean isNull20 = i.isNullAt(9);
/* 049 */     UTF8String value20 = isNull20 ? null : (i.getUTF8String(9));
/* 050 */     boolean isNull19 = true;
/* 051 */     java.lang.String value19 = null;
/* 052 */     if (!isNull20) {
/* 053 */
/* 054 */       isNull19 = false;
/* 055 */       if (!isNull19) {
/* 056 */
/* 057 */         Object funcResult9 = null;
/* 058 */         funcResult9 = value20.toString();
/* 059 */         value19 = (java.lang.String) funcResult9;
/* 060 */
/* 061 */       }
/* 062 */     }
/* 063 */     if (isNull19) {
/* 064 */       values[9] = null;
/* 065 */     } else {
/* 066 */       values[9] = value19;
/* 067 */     }
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */
/* 072 */   private void apply_7(InternalRow i) {
/* 073 */
/* 074 */     boolean isNull31 = i.isNullAt(19);
/* 075 */     int value31 = isNull31 ? -1 : (i.getInt(19));
/* 076 */     if (isNull31) {
/* 077 */       values[19] = null;
/* 078 */     } else {
/* 079 */       values[19] = value31;
/* 080 */     }
/* 081 */
/* 082 */     long value32 = i.getLong(20);
/* 083 */     if (false) {
/* 084 */       values[20] = null;
/* 085 */     } else {
/* 086 */       values[20] = value32;
/* 087 */     }
/* 088 */
/* 089 */   }
/* 090 */
/* 091 */
/* 092 */   private void apply_1(InternalRow i) {
/* 093 */
/* 094 */     boolean isNull6 = i.isNullAt(2);
/* 095 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 096 */     boolean isNull5 = true;
/* 097 */     java.lang.String value5 = null;
/* 098 */     if (!isNull6) {
/* 099 */
/* 100 */       isNull5 = false;
/* 101 */       if (!isNull5) {
/* 102 */
/* 103 */         Object funcResult2 = null;
/* 104 */         funcResult2 = value6.toString();
/* 105 */         value5 = (java.lang.String) funcResult2;
/* 106 */
/* 107 */       }
/* 108 */     }
/* 109 */     if (isNull5) {
/* 110 */       values[2] = null;
/* 111 */     } else {
/* 112 */       values[2] = value5;
/* 113 */     }
/* 114 */
/* 115 */     boolean isNull8 = i.isNullAt(3);
/* 116 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(3));
/* 117 */     boolean isNull7 = true;
/* 118 */     java.lang.String value7 = null;
/* 119 */     if (!isNull8) {
/* 120 */
/* 121 */       isNull7 = false;
/* 122 */       if (!isNull7) {
/* 123 */
/* 124 */         Object funcResult3 = null;
/* 125 */         funcResult3 = value8.toString();
/* 126 */         value7 = (java.lang.String) funcResult3;
/* 127 */
/* 128 */       }
/* 129 */     }
/* 130 */     if (isNull7) {
/* 131 */       values[3] = null;
/* 132 */     } else {
/* 133 */       values[3] = value7;
/* 134 */     }
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */
/* 139 */   private void apply_3(InternalRow i) {
/* 140 */
/* 141 */     boolean isNull14 = i.isNullAt(6);
/* 142 */     UTF8String value14 = isNull14 ? null : (i.getUTF8String(6));
/* 143 */     boolean isNull13 = true;
/* 144 */     java.lang.String value13 = null;
/* 145 */     if (!isNull14) {
/* 146 */
/* 147 */       isNull13 = false;
/* 148 */       if (!isNull13) {
/* 149 */
/* 150 */         Object funcResult6 = null;
/* 151 */         funcResult6 = value14.toString();
/* 152 */         value13 = (java.lang.String) funcResult6;
/* 153 */
/* 154 */       }
/* 155 */     }
/* 156 */     if (isNull13) {
/* 157 */       values[6] = null;
/* 158 */     } else {
/* 159 */       values[6] = value13;
/* 160 */     }
/* 161 */
/* 162 */     boolean isNull16 = i.isNullAt(7);
/* 163 */     UTF8String value16 = isNull16 ? null : (i.getUTF8String(7));
/* 164 */     boolean isNull15 = true;
/* 165 */     java.lang.String value15 = null;
/* 166 */     if (!isNull16) {
/* 167 */
/* 168 */       isNull15 = false;
/* 169 */       if (!isNull15) {
/* 170 */
/* 171 */         Object funcResult7 = null;
/* 172 */         funcResult7 = value16.toString();
/* 173 */         value15 = (java.lang.String) funcResult7;
/* 174 */
/* 175 */       }
/* 176 */     }
/* 177 */     if (isNull15) {
/* 178 */       values[7] = null;
/* 179 */     } else {
/* 180 */       values[7] = value15;
/* 181 */     }
/* 182 */
/* 183 */   }
/* 184 */
/* 185 */
/* 186 */   private void apply_6(InternalRow i) {
/* 187 */
/* 188 */     boolean isNull26 = i.isNullAt(14);
/* 189 */     double value26 = isNull26 ? -1.0 : (i.getDouble(14));
/* 190 */     if (isNull26) {
/* 191 */       values[14] = null;
/* 192 */     } else {
/* 193 */       values[14] = value26;
/* 194 */     }
/* 195 */
/* 196 */     boolean isNull27 = i.isNullAt(15);
/* 197 */     double value27 = isNull27 ? -1.0 : (i.getDouble(15));
/* 198 */     if (isNull27) {
/* 199 */       values[15] = null;
/* 200 */     } else {
/* 201 */       values[15] = value27;
/* 202 */     }
/* 203 */
/* 204 */     boolean isNull28 = i.isNullAt(16);
/* 205 */     double value28 = isNull28 ? -1.0 : (i.getDouble(16));
/* 206 */     if (isNull28) {
/* 207 */       values[16] = null;
/* 208 */     } else {
/* 209 */       values[16] = value28;
/* 210 */     }
/* 211 */
/* 212 */     boolean isNull29 = i.isNullAt(17);
/* 213 */     double value29 = isNull29 ? -1.0 : (i.getDouble(17));
/* 214 */     if (isNull29) {
/* 215 */       values[17] = null;
/* 216 */     } else {
/* 217 */       values[17] = value29;
/* 218 */     }
/* 219 */
/* 220 */     boolean isNull30 = i.isNullAt(18);
/* 221 */     double value30 = isNull30 ? -1.0 : (i.getDouble(18));
/* 222 */     if (isNull30) {
/* 223 */       values[18] = null;
/* 224 */     } else {
/* 225 */       values[18] = value30;
/* 226 */     }
/* 227 */
/* 228 */   }
/* 229 */
/* 230 */
/* 231 */   private void apply_0(InternalRow i) {
/* 232 */
/* 233 */     boolean isNull2 = i.isNullAt(0);
/* 234 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 235 */     boolean isNull1 = true;
/* 236 */     java.lang.String value1 = null;
/* 237 */     if (!isNull2) {
/* 238 */
/* 239 */       isNull1 = false;
/* 240 */       if (!isNull1) {
/* 241 */
/* 242 */         Object funcResult = null;
/* 243 */         funcResult = value2.toString();
/* 244 */         value1 = (java.lang.String) funcResult;
/* 245 */
/* 246 */       }
/* 247 */     }
/* 248 */     if (isNull1) {
/* 249 */       values[0] = null;
/* 250 */     } else {
/* 251 */       values[0] = value1;
/* 252 */     }
/* 253 */
/* 254 */     boolean isNull4 = i.isNullAt(1);
/* 255 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 256 */     boolean isNull3 = true;
/* 257 */     java.lang.String value3 = null;
/* 258 */     if (!isNull4) {
/* 259 */
/* 260 */       isNull3 = false;
/* 261 */       if (!isNull3) {
/* 262 */
/* 263 */         Object funcResult1 = null;
/* 264 */         funcResult1 = value4.toString();
/* 265 */         value3 = (java.lang.String) funcResult1;
/* 266 */
/* 267 */       }
/* 268 */     }
/* 269 */     if (isNull3) {
/* 270 */       values[1] = null;
/* 271 */     } else {
/* 272 */       values[1] = value3;
/* 273 */     }
/* 274 */
/* 275 */   }
/* 276 */
/* 277 */
/* 278 */   private void apply_2(InternalRow i) {
/* 279 */
/* 280 */     boolean isNull10 = i.isNullAt(4);
/* 281 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(4));
/* 282 */     boolean isNull9 = true;
/* 283 */     java.lang.String value9 = null;
/* 284 */     if (!isNull10) {
/* 285 */
/* 286 */       isNull9 = false;
/* 287 */       if (!isNull9) {
/* 288 */
/* 289 */         Object funcResult4 = null;
/* 290 */         funcResult4 = value10.toString();
/* 291 */         value9 = (java.lang.String) funcResult4;
/* 292 */
/* 293 */       }
/* 294 */     }
/* 295 */     if (isNull9) {
/* 296 */       values[4] = null;
/* 297 */     } else {
/* 298 */       values[4] = value9;
/* 299 */     }
/* 300 */
/* 301 */     boolean isNull12 = i.isNullAt(5);
/* 302 */     UTF8String value12 = isNull12 ? null : (i.getUTF8String(5));
/* 303 */     boolean isNull11 = true;
/* 304 */     java.lang.String value11 = null;
/* 305 */     if (!isNull12) {
/* 306 */
/* 307 */       isNull11 = false;
/* 308 */       if (!isNull11) {
/* 309 */
/* 310 */         Object funcResult5 = null;
/* 311 */         funcResult5 = value12.toString();
/* 312 */         value11 = (java.lang.String) funcResult5;
/* 313 */
/* 314 */       }
/* 315 */     }
/* 316 */     if (isNull11) {
/* 317 */       values[5] = null;
/* 318 */     } else {
/* 319 */       values[5] = value11;
/* 320 */     }
/* 321 */
/* 322 */   }
/* 323 */
/* 324 */
/* 325 */   private void apply_5(InternalRow i) {
/* 326 */
/* 327 */     boolean isNull22 = i.isNullAt(10);
/* 328 */     UTF8String value22 = isNull22 ? null : (i.getUTF8String(10));
/* 329 */     boolean isNull21 = true;
/* 330 */     java.lang.String value21 = null;
/* 331 */     if (!isNull22) {
/* 332 */
/* 333 */       isNull21 = false;
/* 334 */       if (!isNull21) {
/* 335 */
/* 336 */         Object funcResult10 = null;
/* 337 */         funcResult10 = value22.toString();
/* 338 */         value21 = (java.lang.String) funcResult10;
/* 339 */
/* 340 */       }
/* 341 */     }
/* 342 */     if (isNull21) {
/* 343 */       values[10] = null;
/* 344 */     } else {
/* 345 */       values[10] = value21;
/* 346 */     }
/* 347 */
/* 348 */     boolean isNull23 = i.isNullAt(11);
/* 349 */     int value23 = isNull23 ? -1 : (i.getInt(11));
/* 350 */     if (isNull23) {
/* 351 */       values[11] = null;
/* 352 */     } else {
/* 353 */       values[11] = value23;
/* 354 */     }
/* 355 */
/* 356 */     long value24 = i.getLong(12);
/* 357 */     if (false) {
/* 358 */       values[12] = null;
/* 359 */     } else {
/* 360 */       values[12] = value24;
/* 361 */     }
/* 362 */
/* 363 */     boolean isNull25 = i.isNullAt(13);
/* 364 */     double value25 = isNull25 ? -1.0 : (i.getDouble(13));
/* 365 */     if (isNull25) {
/* 366 */       values[13] = null;
/* 367 */     } else {
/* 368 */       values[13] = value25;
/* 369 */     }
/* 370 */
/* 371 */   }
/* 372 */
/* 373 */
/* 374 */   public java.lang.Object apply(java.lang.Object _i) {
/* 375 */     InternalRow i = (InternalRow) _i;
/* 376 */
/* 377 */     values = new Object[21];
/* 378 */     apply_0(i);
/* 379 */     apply_1(i);
/* 380 */     apply_2(i);
/* 381 */     apply_3(i);
/* 382 */     apply_4(i);
/* 383 */     apply_5(i);
/* 384 */     apply_6(i);
/* 385 */     apply_7(i);
/* 386 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 387 */     if (false) {
/* 388 */       mutableRow.setNullAt(0);
/* 389 */     } else {
/* 390 */
/* 391 */       mutableRow.update(0, value);
/* 392 */     }
/* 393 */
/* 394 */     return mutableRow;
/* 395 */   }
/* 396 */ }
