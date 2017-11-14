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
/* 014 */     result = new UnsafeRow(35);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 35);
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
/* 028 */     boolean isNull17 = i.isNullAt(17);
/* 029 */     double value17 = isNull17 ? -1.0 : (i.getDouble(17));
/* 030 */     if (isNull17) {
/* 031 */       rowWriter.setNullAt(17);
/* 032 */     } else {
/* 033 */       rowWriter.write(17, value17);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull18 = i.isNullAt(18);
/* 038 */     double value18 = isNull18 ? -1.0 : (i.getDouble(18));
/* 039 */     if (isNull18) {
/* 040 */       rowWriter.setNullAt(18);
/* 041 */     } else {
/* 042 */       rowWriter.write(18, value18);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull19 = i.isNullAt(19);
/* 047 */     double value19 = isNull19 ? -1.0 : (i.getDouble(19));
/* 048 */     if (isNull19) {
/* 049 */       rowWriter.setNullAt(19);
/* 050 */     } else {
/* 051 */       rowWriter.write(19, value19);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull20 = i.isNullAt(20);
/* 056 */     double value20 = isNull20 ? -1.0 : (i.getDouble(20));
/* 057 */     if (isNull20) {
/* 058 */       rowWriter.setNullAt(20);
/* 059 */     } else {
/* 060 */       rowWriter.write(20, value20);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_7(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull29 = i.isNullAt(29);
/* 070 */     long value29 = isNull29 ? -1L : (i.getLong(29));
/* 071 */     if (isNull29) {
/* 072 */       rowWriter.setNullAt(29);
/* 073 */     } else {
/* 074 */       rowWriter.write(29, value29);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull30 = i.isNullAt(30);
/* 079 */     double value30 = isNull30 ? -1.0 : (i.getDouble(30));
/* 080 */     if (isNull30) {
/* 081 */       rowWriter.setNullAt(30);
/* 082 */     } else {
/* 083 */       rowWriter.write(30, value30);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull31 = i.isNullAt(31);
/* 088 */     double value31 = isNull31 ? -1.0 : (i.getDouble(31));
/* 089 */     if (isNull31) {
/* 090 */       rowWriter.setNullAt(31);
/* 091 */     } else {
/* 092 */       rowWriter.write(31, value31);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull32 = i.isNullAt(32);
/* 097 */     double value32 = isNull32 ? -1.0 : (i.getDouble(32));
/* 098 */     if (isNull32) {
/* 099 */       rowWriter.setNullAt(32);
/* 100 */     } else {
/* 101 */       rowWriter.write(32, value32);
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   private void apply_1(InternalRow i) {
/* 108 */
/* 109 */
/* 110 */     boolean isNull5 = i.isNullAt(5);
/* 111 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 112 */     if (isNull5) {
/* 113 */       rowWriter.setNullAt(5);
/* 114 */     } else {
/* 115 */       rowWriter.write(5, value5);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull6 = i.isNullAt(6);
/* 120 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 121 */     if (isNull6) {
/* 122 */       rowWriter.setNullAt(6);
/* 123 */     } else {
/* 124 */       rowWriter.write(6, value6);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull7 = i.isNullAt(7);
/* 129 */     double value7 = isNull7 ? -1.0 : (i.getDouble(7));
/* 130 */     if (isNull7) {
/* 131 */       rowWriter.setNullAt(7);
/* 132 */     } else {
/* 133 */       rowWriter.write(7, value7);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull8 = i.isNullAt(8);
/* 138 */     double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 139 */     if (isNull8) {
/* 140 */       rowWriter.setNullAt(8);
/* 141 */     } else {
/* 142 */       rowWriter.write(8, value8);
/* 143 */     }
/* 144 */
/* 145 */   }
/* 146 */
/* 147 */
/* 148 */   private void apply_3(InternalRow i) {
/* 149 */
/* 150 */
/* 151 */     boolean isNull13 = i.isNullAt(13);
/* 152 */     long value13 = isNull13 ? -1L : (i.getLong(13));
/* 153 */     if (isNull13) {
/* 154 */       rowWriter.setNullAt(13);
/* 155 */     } else {
/* 156 */       rowWriter.write(13, value13);
/* 157 */     }
/* 158 */
/* 159 */
/* 160 */     boolean isNull14 = i.isNullAt(14);
/* 161 */     double value14 = isNull14 ? -1.0 : (i.getDouble(14));
/* 162 */     if (isNull14) {
/* 163 */       rowWriter.setNullAt(14);
/* 164 */     } else {
/* 165 */       rowWriter.write(14, value14);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull15 = i.isNullAt(15);
/* 170 */     double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 171 */     if (isNull15) {
/* 172 */       rowWriter.setNullAt(15);
/* 173 */     } else {
/* 174 */       rowWriter.write(15, value15);
/* 175 */     }
/* 176 */
/* 177 */
/* 178 */     boolean isNull16 = i.isNullAt(16);
/* 179 */     double value16 = isNull16 ? -1.0 : (i.getDouble(16));
/* 180 */     if (isNull16) {
/* 181 */       rowWriter.setNullAt(16);
/* 182 */     } else {
/* 183 */       rowWriter.write(16, value16);
/* 184 */     }
/* 185 */
/* 186 */   }
/* 187 */
/* 188 */
/* 189 */   private void apply_6(InternalRow i) {
/* 190 */
/* 191 */
/* 192 */     boolean isNull25 = i.isNullAt(25);
/* 193 */     double value25 = isNull25 ? -1.0 : (i.getDouble(25));
/* 194 */     if (isNull25) {
/* 195 */       rowWriter.setNullAt(25);
/* 196 */     } else {
/* 197 */       rowWriter.write(25, value25);
/* 198 */     }
/* 199 */
/* 200 */
/* 201 */     boolean isNull26 = i.isNullAt(26);
/* 202 */     double value26 = isNull26 ? -1.0 : (i.getDouble(26));
/* 203 */     if (isNull26) {
/* 204 */       rowWriter.setNullAt(26);
/* 205 */     } else {
/* 206 */       rowWriter.write(26, value26);
/* 207 */     }
/* 208 */
/* 209 */
/* 210 */     boolean isNull27 = i.isNullAt(27);
/* 211 */     double value27 = isNull27 ? -1.0 : (i.getDouble(27));
/* 212 */     if (isNull27) {
/* 213 */       rowWriter.setNullAt(27);
/* 214 */     } else {
/* 215 */       rowWriter.write(27, value27);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     boolean isNull28 = i.isNullAt(28);
/* 220 */     double value28 = isNull28 ? -1.0 : (i.getDouble(28));
/* 221 */     if (isNull28) {
/* 222 */       rowWriter.setNullAt(28);
/* 223 */     } else {
/* 224 */       rowWriter.write(28, value28);
/* 225 */     }
/* 226 */
/* 227 */   }
/* 228 */
/* 229 */
/* 230 */   private void apply_0(InternalRow i) {
/* 231 */
/* 232 */
/* 233 */     boolean isNull = i.isNullAt(0);
/* 234 */     long value = isNull ? -1L : (i.getLong(0));
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
/* 252 */     long value2 = isNull2 ? -1L : (i.getLong(2));
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
/* 268 */
/* 269 */     boolean isNull4 = i.isNullAt(4);
/* 270 */     double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 271 */     if (isNull4) {
/* 272 */       rowWriter.setNullAt(4);
/* 273 */     } else {
/* 274 */       rowWriter.write(4, value4);
/* 275 */     }
/* 276 */
/* 277 */   }
/* 278 */
/* 279 */
/* 280 */   private void apply_8(InternalRow i) {
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
/* 293 */     long value34 = isNull34 ? -1L : (i.getLong(34));
/* 294 */     if (isNull34) {
/* 295 */       rowWriter.setNullAt(34);
/* 296 */     } else {
/* 297 */       rowWriter.write(34, value34);
/* 298 */     }
/* 299 */
/* 300 */   }
/* 301 */
/* 302 */
/* 303 */   private void apply_2(InternalRow i) {
/* 304 */
/* 305 */
/* 306 */     boolean isNull9 = i.isNullAt(9);
/* 307 */     double value9 = isNull9 ? -1.0 : (i.getDouble(9));
/* 308 */     if (isNull9) {
/* 309 */       rowWriter.setNullAt(9);
/* 310 */     } else {
/* 311 */       rowWriter.write(9, value9);
/* 312 */     }
/* 313 */
/* 314 */
/* 315 */     boolean isNull10 = i.isNullAt(10);
/* 316 */     long value10 = isNull10 ? -1L : (i.getLong(10));
/* 317 */     if (isNull10) {
/* 318 */       rowWriter.setNullAt(10);
/* 319 */     } else {
/* 320 */       rowWriter.write(10, value10);
/* 321 */     }
/* 322 */
/* 323 */
/* 324 */     boolean isNull11 = i.isNullAt(11);
/* 325 */     long value11 = isNull11 ? -1L : (i.getLong(11));
/* 326 */     if (isNull11) {
/* 327 */       rowWriter.setNullAt(11);
/* 328 */     } else {
/* 329 */       rowWriter.write(11, value11);
/* 330 */     }
/* 331 */
/* 332 */
/* 333 */     boolean isNull12 = i.isNullAt(12);
/* 334 */     double value12 = isNull12 ? -1.0 : (i.getDouble(12));
/* 335 */     if (isNull12) {
/* 336 */       rowWriter.setNullAt(12);
/* 337 */     } else {
/* 338 */       rowWriter.write(12, value12);
/* 339 */     }
/* 340 */
/* 341 */   }
/* 342 */
/* 343 */
/* 344 */   private void apply_5(InternalRow i) {
/* 345 */
/* 346 */
/* 347 */     boolean isNull21 = i.isNullAt(21);
/* 348 */     long value21 = isNull21 ? -1L : (i.getLong(21));
/* 349 */     if (isNull21) {
/* 350 */       rowWriter.setNullAt(21);
/* 351 */     } else {
/* 352 */       rowWriter.write(21, value21);
/* 353 */     }
/* 354 */
/* 355 */
/* 356 */     boolean isNull22 = i.isNullAt(22);
/* 357 */     long value22 = isNull22 ? -1L : (i.getLong(22));
/* 358 */     if (isNull22) {
/* 359 */       rowWriter.setNullAt(22);
/* 360 */     } else {
/* 361 */       rowWriter.write(22, value22);
/* 362 */     }
/* 363 */
/* 364 */
/* 365 */     boolean isNull23 = i.isNullAt(23);
/* 366 */     double value23 = isNull23 ? -1.0 : (i.getDouble(23));
/* 367 */     if (isNull23) {
/* 368 */       rowWriter.setNullAt(23);
/* 369 */     } else {
/* 370 */       rowWriter.write(23, value23);
/* 371 */     }
/* 372 */
/* 373 */
/* 374 */     boolean isNull24 = i.isNullAt(24);
/* 375 */     long value24 = isNull24 ? -1L : (i.getLong(24));
/* 376 */     if (isNull24) {
/* 377 */       rowWriter.setNullAt(24);
/* 378 */     } else {
/* 379 */       rowWriter.write(24, value24);
/* 380 */     }
/* 381 */
/* 382 */   }
/* 383 */
/* 384 */
/* 385 */   // Scala.Function1 need this
/* 386 */   public java.lang.Object apply(java.lang.Object row) {
/* 387 */     return apply((InternalRow) row);
/* 388 */   }
/* 389 */
/* 390 */   public UnsafeRow apply(InternalRow i) {
/* 391 */     rowWriter.zeroOutNullBytes();
/* 392 */     apply_0(i);
/* 393 */     apply_1(i);
/* 394 */     apply_2(i);
/* 395 */     apply_3(i);
/* 396 */     apply_4(i);
/* 397 */     apply_5(i);
/* 398 */     apply_6(i);
/* 399 */     apply_7(i);
/* 400 */     apply_8(i);
/* 401 */     return result;
/* 402 */   }
/* 403 */ }
