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
/* 074 */     boolean isNull30 = i.isNullAt(15);
/* 075 */     double value30 = isNull30 ? -1.0 : (i.getDouble(15));
/* 076 */     if (isNull30) {
/* 077 */       values[15] = null;
/* 078 */     } else {
/* 079 */       values[15] = value30;
/* 080 */     }
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */
/* 085 */   private void apply_1(InternalRow i) {
/* 086 */
/* 087 */     boolean isNull6 = i.isNullAt(2);
/* 088 */     UTF8String value6 = isNull6 ? null : (i.getUTF8String(2));
/* 089 */     boolean isNull5 = true;
/* 090 */     java.lang.String value5 = null;
/* 091 */     if (!isNull6) {
/* 092 */
/* 093 */       isNull5 = false;
/* 094 */       if (!isNull5) {
/* 095 */
/* 096 */         Object funcResult2 = null;
/* 097 */         funcResult2 = value6.toString();
/* 098 */         value5 = (java.lang.String) funcResult2;
/* 099 */
/* 100 */       }
/* 101 */     }
/* 102 */     if (isNull5) {
/* 103 */       values[2] = null;
/* 104 */     } else {
/* 105 */       values[2] = value5;
/* 106 */     }
/* 107 */
/* 108 */     boolean isNull8 = i.isNullAt(3);
/* 109 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(3));
/* 110 */     boolean isNull7 = true;
/* 111 */     java.lang.String value7 = null;
/* 112 */     if (!isNull8) {
/* 113 */
/* 114 */       isNull7 = false;
/* 115 */       if (!isNull7) {
/* 116 */
/* 117 */         Object funcResult3 = null;
/* 118 */         funcResult3 = value8.toString();
/* 119 */         value7 = (java.lang.String) funcResult3;
/* 120 */
/* 121 */       }
/* 122 */     }
/* 123 */     if (isNull7) {
/* 124 */       values[3] = null;
/* 125 */     } else {
/* 126 */       values[3] = value7;
/* 127 */     }
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */
/* 132 */   private void apply_3(InternalRow i) {
/* 133 */
/* 134 */     boolean isNull14 = i.isNullAt(6);
/* 135 */     UTF8String value14 = isNull14 ? null : (i.getUTF8String(6));
/* 136 */     boolean isNull13 = true;
/* 137 */     java.lang.String value13 = null;
/* 138 */     if (!isNull14) {
/* 139 */
/* 140 */       isNull13 = false;
/* 141 */       if (!isNull13) {
/* 142 */
/* 143 */         Object funcResult6 = null;
/* 144 */         funcResult6 = value14.toString();
/* 145 */         value13 = (java.lang.String) funcResult6;
/* 146 */
/* 147 */       }
/* 148 */     }
/* 149 */     if (isNull13) {
/* 150 */       values[6] = null;
/* 151 */     } else {
/* 152 */       values[6] = value13;
/* 153 */     }
/* 154 */
/* 155 */     boolean isNull16 = i.isNullAt(7);
/* 156 */     UTF8String value16 = isNull16 ? null : (i.getUTF8String(7));
/* 157 */     boolean isNull15 = true;
/* 158 */     java.lang.String value15 = null;
/* 159 */     if (!isNull16) {
/* 160 */
/* 161 */       isNull15 = false;
/* 162 */       if (!isNull15) {
/* 163 */
/* 164 */         Object funcResult7 = null;
/* 165 */         funcResult7 = value16.toString();
/* 166 */         value15 = (java.lang.String) funcResult7;
/* 167 */
/* 168 */       }
/* 169 */     }
/* 170 */     if (isNull15) {
/* 171 */       values[7] = null;
/* 172 */     } else {
/* 173 */       values[7] = value15;
/* 174 */     }
/* 175 */
/* 176 */   }
/* 177 */
/* 178 */
/* 179 */   private void apply_6(InternalRow i) {
/* 180 */
/* 181 */     boolean isNull26 = i.isNullAt(12);
/* 182 */     UTF8String value26 = isNull26 ? null : (i.getUTF8String(12));
/* 183 */     boolean isNull25 = true;
/* 184 */     java.lang.String value25 = null;
/* 185 */     if (!isNull26) {
/* 186 */
/* 187 */       isNull25 = false;
/* 188 */       if (!isNull25) {
/* 189 */
/* 190 */         Object funcResult12 = null;
/* 191 */         funcResult12 = value26.toString();
/* 192 */         value25 = (java.lang.String) funcResult12;
/* 193 */
/* 194 */       }
/* 195 */     }
/* 196 */     if (isNull25) {
/* 197 */       values[12] = null;
/* 198 */     } else {
/* 199 */       values[12] = value25;
/* 200 */     }
/* 201 */
/* 202 */     boolean isNull27 = i.isNullAt(13);
/* 203 */     double value27 = isNull27 ? -1.0 : (i.getDouble(13));
/* 204 */     if (isNull27) {
/* 205 */       values[13] = null;
/* 206 */     } else {
/* 207 */       values[13] = value27;
/* 208 */     }
/* 209 */
/* 210 */     boolean isNull29 = i.isNullAt(14);
/* 211 */     UTF8String value29 = isNull29 ? null : (i.getUTF8String(14));
/* 212 */     boolean isNull28 = true;
/* 213 */     java.lang.String value28 = null;
/* 214 */     if (!isNull29) {
/* 215 */
/* 216 */       isNull28 = false;
/* 217 */       if (!isNull28) {
/* 218 */
/* 219 */         Object funcResult13 = null;
/* 220 */         funcResult13 = value29.toString();
/* 221 */         value28 = (java.lang.String) funcResult13;
/* 222 */
/* 223 */       }
/* 224 */     }
/* 225 */     if (isNull28) {
/* 226 */       values[14] = null;
/* 227 */     } else {
/* 228 */       values[14] = value28;
/* 229 */     }
/* 230 */
/* 231 */   }
/* 232 */
/* 233 */
/* 234 */   private void apply_0(InternalRow i) {
/* 235 */
/* 236 */     boolean isNull2 = i.isNullAt(0);
/* 237 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 238 */     boolean isNull1 = true;
/* 239 */     java.lang.String value1 = null;
/* 240 */     if (!isNull2) {
/* 241 */
/* 242 */       isNull1 = false;
/* 243 */       if (!isNull1) {
/* 244 */
/* 245 */         Object funcResult = null;
/* 246 */         funcResult = value2.toString();
/* 247 */         value1 = (java.lang.String) funcResult;
/* 248 */
/* 249 */       }
/* 250 */     }
/* 251 */     if (isNull1) {
/* 252 */       values[0] = null;
/* 253 */     } else {
/* 254 */       values[0] = value1;
/* 255 */     }
/* 256 */
/* 257 */     boolean isNull4 = i.isNullAt(1);
/* 258 */     UTF8String value4 = isNull4 ? null : (i.getUTF8String(1));
/* 259 */     boolean isNull3 = true;
/* 260 */     java.lang.String value3 = null;
/* 261 */     if (!isNull4) {
/* 262 */
/* 263 */       isNull3 = false;
/* 264 */       if (!isNull3) {
/* 265 */
/* 266 */         Object funcResult1 = null;
/* 267 */         funcResult1 = value4.toString();
/* 268 */         value3 = (java.lang.String) funcResult1;
/* 269 */
/* 270 */       }
/* 271 */     }
/* 272 */     if (isNull3) {
/* 273 */       values[1] = null;
/* 274 */     } else {
/* 275 */       values[1] = value3;
/* 276 */     }
/* 277 */
/* 278 */   }
/* 279 */
/* 280 */
/* 281 */   private void apply_2(InternalRow i) {
/* 282 */
/* 283 */     boolean isNull10 = i.isNullAt(4);
/* 284 */     UTF8String value10 = isNull10 ? null : (i.getUTF8String(4));
/* 285 */     boolean isNull9 = true;
/* 286 */     java.lang.String value9 = null;
/* 287 */     if (!isNull10) {
/* 288 */
/* 289 */       isNull9 = false;
/* 290 */       if (!isNull9) {
/* 291 */
/* 292 */         Object funcResult4 = null;
/* 293 */         funcResult4 = value10.toString();
/* 294 */         value9 = (java.lang.String) funcResult4;
/* 295 */
/* 296 */       }
/* 297 */     }
/* 298 */     if (isNull9) {
/* 299 */       values[4] = null;
/* 300 */     } else {
/* 301 */       values[4] = value9;
/* 302 */     }
/* 303 */
/* 304 */     boolean isNull12 = i.isNullAt(5);
/* 305 */     UTF8String value12 = isNull12 ? null : (i.getUTF8String(5));
/* 306 */     boolean isNull11 = true;
/* 307 */     java.lang.String value11 = null;
/* 308 */     if (!isNull12) {
/* 309 */
/* 310 */       isNull11 = false;
/* 311 */       if (!isNull11) {
/* 312 */
/* 313 */         Object funcResult5 = null;
/* 314 */         funcResult5 = value12.toString();
/* 315 */         value11 = (java.lang.String) funcResult5;
/* 316 */
/* 317 */       }
/* 318 */     }
/* 319 */     if (isNull11) {
/* 320 */       values[5] = null;
/* 321 */     } else {
/* 322 */       values[5] = value11;
/* 323 */     }
/* 324 */
/* 325 */   }
/* 326 */
/* 327 */
/* 328 */   private void apply_5(InternalRow i) {
/* 329 */
/* 330 */     boolean isNull22 = i.isNullAt(10);
/* 331 */     UTF8String value22 = isNull22 ? null : (i.getUTF8String(10));
/* 332 */     boolean isNull21 = true;
/* 333 */     java.lang.String value21 = null;
/* 334 */     if (!isNull22) {
/* 335 */
/* 336 */       isNull21 = false;
/* 337 */       if (!isNull21) {
/* 338 */
/* 339 */         Object funcResult10 = null;
/* 340 */         funcResult10 = value22.toString();
/* 341 */         value21 = (java.lang.String) funcResult10;
/* 342 */
/* 343 */       }
/* 344 */     }
/* 345 */     if (isNull21) {
/* 346 */       values[10] = null;
/* 347 */     } else {
/* 348 */       values[10] = value21;
/* 349 */     }
/* 350 */
/* 351 */     boolean isNull24 = i.isNullAt(11);
/* 352 */     UTF8String value24 = isNull24 ? null : (i.getUTF8String(11));
/* 353 */     boolean isNull23 = true;
/* 354 */     java.lang.String value23 = null;
/* 355 */     if (!isNull24) {
/* 356 */
/* 357 */       isNull23 = false;
/* 358 */       if (!isNull23) {
/* 359 */
/* 360 */         Object funcResult11 = null;
/* 361 */         funcResult11 = value24.toString();
/* 362 */         value23 = (java.lang.String) funcResult11;
/* 363 */
/* 364 */       }
/* 365 */     }
/* 366 */     if (isNull23) {
/* 367 */       values[11] = null;
/* 368 */     } else {
/* 369 */       values[11] = value23;
/* 370 */     }
/* 371 */
/* 372 */   }
/* 373 */
/* 374 */
/* 375 */   public java.lang.Object apply(java.lang.Object _i) {
/* 376 */     InternalRow i = (InternalRow) _i;
/* 377 */
/* 378 */     values = new Object[16];
/* 379 */     apply_0(i);
/* 380 */     apply_1(i);
/* 381 */     apply_2(i);
/* 382 */     apply_3(i);
/* 383 */     apply_4(i);
/* 384 */     apply_5(i);
/* 385 */     apply_6(i);
/* 386 */     apply_7(i);
/* 387 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 388 */     if (false) {
/* 389 */       mutableRow.setNullAt(0);
/* 390 */     } else {
/* 391 */
/* 392 */       mutableRow.update(0, value);
/* 393 */     }
/* 394 */
/* 395 */     return mutableRow;
/* 396 */   }
/* 397 */ }
