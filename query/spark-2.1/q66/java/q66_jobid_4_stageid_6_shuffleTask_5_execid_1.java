/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(36);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 36);
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
/* 027 */
/* 028 */     boolean isNull16 = i.isNullAt(16);
/* 029 */     double value16 = isNull16 ? -1.0 : (i.getDouble(16));
/* 030 */     if (isNull16) {
/* 031 */       rowWriter.setNullAt(16);
/* 032 */     } else {
/* 033 */       rowWriter.write(16, value16);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull17 = i.isNullAt(17);
/* 038 */     double value17 = isNull17 ? -1.0 : (i.getDouble(17));
/* 039 */     if (isNull17) {
/* 040 */       rowWriter.setNullAt(17);
/* 041 */     } else {
/* 042 */       rowWriter.write(17, value17);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull18 = i.isNullAt(18);
/* 047 */     double value18 = isNull18 ? -1.0 : (i.getDouble(18));
/* 048 */     if (isNull18) {
/* 049 */       rowWriter.setNullAt(18);
/* 050 */     } else {
/* 051 */       rowWriter.write(18, value18);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull19 = i.isNullAt(19);
/* 056 */     double value19 = isNull19 ? -1.0 : (i.getDouble(19));
/* 057 */     if (isNull19) {
/* 058 */       rowWriter.setNullAt(19);
/* 059 */     } else {
/* 060 */       rowWriter.write(19, value19);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_7(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull28 = i.isNullAt(28);
/* 070 */     double value28 = isNull28 ? -1.0 : (i.getDouble(28));
/* 071 */     if (isNull28) {
/* 072 */       rowWriter.setNullAt(28);
/* 073 */     } else {
/* 074 */       rowWriter.write(28, value28);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull29 = i.isNullAt(29);
/* 079 */     double value29 = isNull29 ? -1.0 : (i.getDouble(29));
/* 080 */     if (isNull29) {
/* 081 */       rowWriter.setNullAt(29);
/* 082 */     } else {
/* 083 */       rowWriter.write(29, value29);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull30 = i.isNullAt(30);
/* 088 */     double value30 = isNull30 ? -1.0 : (i.getDouble(30));
/* 089 */     if (isNull30) {
/* 090 */       rowWriter.setNullAt(30);
/* 091 */     } else {
/* 092 */       rowWriter.write(30, value30);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull31 = i.isNullAt(31);
/* 097 */     double value31 = isNull31 ? -1.0 : (i.getDouble(31));
/* 098 */     if (isNull31) {
/* 099 */       rowWriter.setNullAt(31);
/* 100 */     } else {
/* 101 */       rowWriter.write(31, value31);
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   private void apply_1(InternalRow i) {
/* 108 */
/* 109 */
/* 110 */     boolean isNull4 = i.isNullAt(4);
/* 111 */     double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 112 */     if (isNull4) {
/* 113 */       rowWriter.setNullAt(4);
/* 114 */     } else {
/* 115 */       rowWriter.write(4, value4);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull5 = i.isNullAt(5);
/* 120 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 121 */     if (isNull5) {
/* 122 */       rowWriter.setNullAt(5);
/* 123 */     } else {
/* 124 */       rowWriter.write(5, value5);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull6 = i.isNullAt(6);
/* 129 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 130 */     if (isNull6) {
/* 131 */       rowWriter.setNullAt(6);
/* 132 */     } else {
/* 133 */       rowWriter.write(6, value6);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull7 = i.isNullAt(7);
/* 138 */     double value7 = isNull7 ? -1.0 : (i.getDouble(7));
/* 139 */     if (isNull7) {
/* 140 */       rowWriter.setNullAt(7);
/* 141 */     } else {
/* 142 */       rowWriter.write(7, value7);
/* 143 */     }
/* 144 */
/* 145 */   }
/* 146 */
/* 147 */
/* 148 */   private void apply_3(InternalRow i) {
/* 149 */
/* 150 */
/* 151 */     boolean isNull12 = i.isNullAt(12);
/* 152 */     double value12 = isNull12 ? -1.0 : (i.getDouble(12));
/* 153 */     if (isNull12) {
/* 154 */       rowWriter.setNullAt(12);
/* 155 */     } else {
/* 156 */       rowWriter.write(12, value12);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull13 = i.isNullAt(13);
/* 161 */     double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 162 */     if (isNull13) {
/* 163 */       rowWriter.setNullAt(13);
/* 164 */     } else {
/* 165 */       rowWriter.write(13, value13);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull14 = i.isNullAt(14);
/* 170 */     double value14 = isNull14 ? -1.0 : (i.getDouble(14));
/* 171 */     if (isNull14) {
/* 172 */       rowWriter.setNullAt(14);
/* 173 */     } else {
/* 174 */       rowWriter.write(14, value14);
/* 175 */     }
/* 176 */
/* 177 */
/* 178 */     boolean isNull15 = i.isNullAt(15);
/* 179 */     double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 180 */     if (isNull15) {
/* 181 */       rowWriter.setNullAt(15);
/* 182 */     } else {
/* 183 */       rowWriter.write(15, value15);
/* 184 */     }
/* 185 */
/* 186 */   }
/* 187 */
/* 188 */
/* 189 */   private void apply_6(InternalRow i) {
/* 190 */
/* 191 */
/* 192 */     boolean isNull24 = i.isNullAt(24);
/* 193 */     double value24 = isNull24 ? -1.0 : (i.getDouble(24));
/* 194 */     if (isNull24) {
/* 195 */       rowWriter.setNullAt(24);
/* 196 */     } else {
/* 197 */       rowWriter.write(24, value24);
/* 198 */     }
/* 199 */
/* 200 */
/* 201 */     boolean isNull25 = i.isNullAt(25);
/* 202 */     double value25 = isNull25 ? -1.0 : (i.getDouble(25));
/* 203 */     if (isNull25) {
/* 204 */       rowWriter.setNullAt(25);
/* 205 */     } else {
/* 206 */       rowWriter.write(25, value25);
/* 207 */     }
/* 208 */
/* 209 */
/* 210 */     boolean isNull26 = i.isNullAt(26);
/* 211 */     double value26 = isNull26 ? -1.0 : (i.getDouble(26));
/* 212 */     if (isNull26) {
/* 213 */       rowWriter.setNullAt(26);
/* 214 */     } else {
/* 215 */       rowWriter.write(26, value26);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     boolean isNull27 = i.isNullAt(27);
/* 220 */     double value27 = isNull27 ? -1.0 : (i.getDouble(27));
/* 221 */     if (isNull27) {
/* 222 */       rowWriter.setNullAt(27);
/* 223 */     } else {
/* 224 */       rowWriter.write(27, value27);
/* 225 */     }
/* 226 */
/* 227 */   }
/* 228 */
/* 229 */
/* 230 */   private void apply_0(InternalRow i) {
/* 231 */
/* 232 */
/* 233 */     boolean isNull = i.isNullAt(0);
/* 234 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 235 */     if (isNull) {
/* 236 */       rowWriter.setNullAt(0);
/* 237 */     } else {
/* 238 */       rowWriter.write(0, value);
/* 239 */     }
/* 240 */
/* 241 */
/* 242 */     boolean isNull1 = i.isNullAt(1);
/* 243 */     double value1 = isNull1 ? -1.0 : (i.getDouble(1));
/* 244 */     if (isNull1) {
/* 245 */       rowWriter.setNullAt(1);
/* 246 */     } else {
/* 247 */       rowWriter.write(1, value1);
/* 248 */     }
/* 249 */
/* 250 */
/* 251 */     boolean isNull2 = i.isNullAt(2);
/* 252 */     double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 253 */     if (isNull2) {
/* 254 */       rowWriter.setNullAt(2);
/* 255 */     } else {
/* 256 */       rowWriter.write(2, value2);
/* 257 */     }
/* 258 */
/* 259 */
/* 260 */     boolean isNull3 = i.isNullAt(3);
/* 261 */     double value3 = isNull3 ? -1.0 : (i.getDouble(3));
/* 262 */     if (isNull3) {
/* 263 */       rowWriter.setNullAt(3);
/* 264 */     } else {
/* 265 */       rowWriter.write(3, value3);
/* 266 */     }
/* 267 */
/* 268 */   }
/* 269 */
/* 270 */
/* 271 */   private void apply_8(InternalRow i) {
/* 272 */
/* 273 */
/* 274 */     boolean isNull32 = i.isNullAt(32);
/* 275 */     double value32 = isNull32 ? -1.0 : (i.getDouble(32));
/* 276 */     if (isNull32) {
/* 277 */       rowWriter.setNullAt(32);
/* 278 */     } else {
/* 279 */       rowWriter.write(32, value32);
/* 280 */     }
/* 281 */
/* 282 */
/* 283 */     boolean isNull33 = i.isNullAt(33);
/* 284 */     double value33 = isNull33 ? -1.0 : (i.getDouble(33));
/* 285 */     if (isNull33) {
/* 286 */       rowWriter.setNullAt(33);
/* 287 */     } else {
/* 288 */       rowWriter.write(33, value33);
/* 289 */     }
/* 290 */
/* 291 */
/* 292 */     boolean isNull34 = i.isNullAt(34);
/* 293 */     double value34 = isNull34 ? -1.0 : (i.getDouble(34));
/* 294 */     if (isNull34) {
/* 295 */       rowWriter.setNullAt(34);
/* 296 */     } else {
/* 297 */       rowWriter.write(34, value34);
/* 298 */     }
/* 299 */
/* 300 */
/* 301 */     boolean isNull35 = i.isNullAt(35);
/* 302 */     double value35 = isNull35 ? -1.0 : (i.getDouble(35));
/* 303 */     if (isNull35) {
/* 304 */       rowWriter.setNullAt(35);
/* 305 */     } else {
/* 306 */       rowWriter.write(35, value35);
/* 307 */     }
/* 308 */
/* 309 */   }
/* 310 */
/* 311 */
/* 312 */   private void apply_2(InternalRow i) {
/* 313 */
/* 314 */
/* 315 */     boolean isNull8 = i.isNullAt(8);
/* 316 */     double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 317 */     if (isNull8) {
/* 318 */       rowWriter.setNullAt(8);
/* 319 */     } else {
/* 320 */       rowWriter.write(8, value8);
/* 321 */     }
/* 322 */
/* 323 */
/* 324 */     boolean isNull9 = i.isNullAt(9);
/* 325 */     double value9 = isNull9 ? -1.0 : (i.getDouble(9));
/* 326 */     if (isNull9) {
/* 327 */       rowWriter.setNullAt(9);
/* 328 */     } else {
/* 329 */       rowWriter.write(9, value9);
/* 330 */     }
/* 331 */
/* 332 */
/* 333 */     boolean isNull10 = i.isNullAt(10);
/* 334 */     double value10 = isNull10 ? -1.0 : (i.getDouble(10));
/* 335 */     if (isNull10) {
/* 336 */       rowWriter.setNullAt(10);
/* 337 */     } else {
/* 338 */       rowWriter.write(10, value10);
/* 339 */     }
/* 340 */
/* 341 */
/* 342 */     boolean isNull11 = i.isNullAt(11);
/* 343 */     double value11 = isNull11 ? -1.0 : (i.getDouble(11));
/* 344 */     if (isNull11) {
/* 345 */       rowWriter.setNullAt(11);
/* 346 */     } else {
/* 347 */       rowWriter.write(11, value11);
/* 348 */     }
/* 349 */
/* 350 */   }
/* 351 */
/* 352 */
/* 353 */   private void apply_5(InternalRow i) {
/* 354 */
/* 355 */
/* 356 */     boolean isNull20 = i.isNullAt(20);
/* 357 */     double value20 = isNull20 ? -1.0 : (i.getDouble(20));
/* 358 */     if (isNull20) {
/* 359 */       rowWriter.setNullAt(20);
/* 360 */     } else {
/* 361 */       rowWriter.write(20, value20);
/* 362 */     }
/* 363 */
/* 364 */
/* 365 */     boolean isNull21 = i.isNullAt(21);
/* 366 */     double value21 = isNull21 ? -1.0 : (i.getDouble(21));
/* 367 */     if (isNull21) {
/* 368 */       rowWriter.setNullAt(21);
/* 369 */     } else {
/* 370 */       rowWriter.write(21, value21);
/* 371 */     }
/* 372 */
/* 373 */
/* 374 */     boolean isNull22 = i.isNullAt(22);
/* 375 */     double value22 = isNull22 ? -1.0 : (i.getDouble(22));
/* 376 */     if (isNull22) {
/* 377 */       rowWriter.setNullAt(22);
/* 378 */     } else {
/* 379 */       rowWriter.write(22, value22);
/* 380 */     }
/* 381 */
/* 382 */
/* 383 */     boolean isNull23 = i.isNullAt(23);
/* 384 */     double value23 = isNull23 ? -1.0 : (i.getDouble(23));
/* 385 */     if (isNull23) {
/* 386 */       rowWriter.setNullAt(23);
/* 387 */     } else {
/* 388 */       rowWriter.write(23, value23);
/* 389 */     }
/* 390 */
/* 391 */   }
/* 392 */
/* 393 */
/* 394 */   // Scala.Function1 need this
/* 395 */   public java.lang.Object apply(java.lang.Object row) {
/* 396 */     return apply((InternalRow) row);
/* 397 */   }
/* 398 */
/* 399 */   public UnsafeRow apply(InternalRow i) {
/* 400 */     rowWriter.zeroOutNullBytes();
/* 401 */     apply_0(i);
/* 402 */     apply_1(i);
/* 403 */     apply_2(i);
/* 404 */     apply_3(i);
/* 405 */     apply_4(i);
/* 406 */     apply_5(i);
/* 407 */     apply_6(i);
/* 408 */     apply_7(i);
/* 409 */     apply_8(i);
/* 410 */     return result;
/* 411 */   }
/* 412 */ }
