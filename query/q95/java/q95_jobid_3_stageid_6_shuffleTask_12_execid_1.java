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
/* 014 */     result = new UnsafeRow(34);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 34);
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
/* 028 */     boolean isNull18 = i.isNullAt(18);
/* 029 */     double value18 = isNull18 ? -1.0 : (i.getDouble(18));
/* 030 */     if (isNull18) {
/* 031 */       rowWriter.setNullAt(18);
/* 032 */     } else {
/* 033 */       rowWriter.write(18, value18);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull19 = i.isNullAt(19);
/* 038 */     double value19 = isNull19 ? -1.0 : (i.getDouble(19));
/* 039 */     if (isNull19) {
/* 040 */       rowWriter.setNullAt(19);
/* 041 */     } else {
/* 042 */       rowWriter.write(19, value19);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull20 = i.isNullAt(20);
/* 047 */     double value20 = isNull20 ? -1.0 : (i.getDouble(20));
/* 048 */     if (isNull20) {
/* 049 */       rowWriter.setNullAt(20);
/* 050 */     } else {
/* 051 */       rowWriter.write(20, value20);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull21 = i.isNullAt(21);
/* 056 */     double value21 = isNull21 ? -1.0 : (i.getDouble(21));
/* 057 */     if (isNull21) {
/* 058 */       rowWriter.setNullAt(21);
/* 059 */     } else {
/* 060 */       rowWriter.write(21, value21);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_7(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull30 = i.isNullAt(30);
/* 070 */     double value30 = isNull30 ? -1.0 : (i.getDouble(30));
/* 071 */     if (isNull30) {
/* 072 */       rowWriter.setNullAt(30);
/* 073 */     } else {
/* 074 */       rowWriter.write(30, value30);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull31 = i.isNullAt(31);
/* 079 */     double value31 = isNull31 ? -1.0 : (i.getDouble(31));
/* 080 */     if (isNull31) {
/* 081 */       rowWriter.setNullAt(31);
/* 082 */     } else {
/* 083 */       rowWriter.write(31, value31);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull32 = i.isNullAt(32);
/* 088 */     double value32 = isNull32 ? -1.0 : (i.getDouble(32));
/* 089 */     if (isNull32) {
/* 090 */       rowWriter.setNullAt(32);
/* 091 */     } else {
/* 092 */       rowWriter.write(32, value32);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull33 = i.isNullAt(33);
/* 097 */     int value33 = isNull33 ? -1 : (i.getInt(33));
/* 098 */     if (isNull33) {
/* 099 */       rowWriter.setNullAt(33);
/* 100 */     } else {
/* 101 */       rowWriter.write(33, value33);
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   private void apply_1(InternalRow i) {
/* 108 */
/* 109 */
/* 110 */     boolean isNull5 = i.isNullAt(5);
/* 111 */     int value5 = isNull5 ? -1 : (i.getInt(5));
/* 112 */     if (isNull5) {
/* 113 */       rowWriter.setNullAt(5);
/* 114 */     } else {
/* 115 */       rowWriter.write(5, value5);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull6 = i.isNullAt(6);
/* 120 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 121 */     if (isNull6) {
/* 122 */       rowWriter.setNullAt(6);
/* 123 */     } else {
/* 124 */       rowWriter.write(6, value6);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull7 = i.isNullAt(7);
/* 129 */     int value7 = isNull7 ? -1 : (i.getInt(7));
/* 130 */     if (isNull7) {
/* 131 */       rowWriter.setNullAt(7);
/* 132 */     } else {
/* 133 */       rowWriter.write(7, value7);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull8 = i.isNullAt(8);
/* 138 */     int value8 = isNull8 ? -1 : (i.getInt(8));
/* 139 */     if (isNull8) {
/* 140 */       rowWriter.setNullAt(8);
/* 141 */     } else {
/* 142 */       rowWriter.write(8, value8);
/* 143 */     }
/* 144 */
/* 145 */
/* 146 */     boolean isNull9 = i.isNullAt(9);
/* 147 */     int value9 = isNull9 ? -1 : (i.getInt(9));
/* 148 */     if (isNull9) {
/* 149 */       rowWriter.setNullAt(9);
/* 150 */     } else {
/* 151 */       rowWriter.write(9, value9);
/* 152 */     }
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */
/* 157 */   private void apply_3(InternalRow i) {
/* 158 */
/* 159 */
/* 160 */     boolean isNull14 = i.isNullAt(14);
/* 161 */     int value14 = isNull14 ? -1 : (i.getInt(14));
/* 162 */     if (isNull14) {
/* 163 */       rowWriter.setNullAt(14);
/* 164 */     } else {
/* 165 */       rowWriter.write(14, value14);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull15 = i.isNullAt(15);
/* 170 */     int value15 = isNull15 ? -1 : (i.getInt(15));
/* 171 */     if (isNull15) {
/* 172 */       rowWriter.setNullAt(15);
/* 173 */     } else {
/* 174 */       rowWriter.write(15, value15);
/* 175 */     }
/* 176 */
/* 177 */
/* 178 */     boolean isNull16 = i.isNullAt(16);
/* 179 */     int value16 = isNull16 ? -1 : (i.getInt(16));
/* 180 */     if (isNull16) {
/* 181 */       rowWriter.setNullAt(16);
/* 182 */     } else {
/* 183 */       rowWriter.write(16, value16);
/* 184 */     }
/* 185 */
/* 186 */
/* 187 */     boolean isNull17 = i.isNullAt(17);
/* 188 */     int value17 = isNull17 ? -1 : (i.getInt(17));
/* 189 */     if (isNull17) {
/* 190 */       rowWriter.setNullAt(17);
/* 191 */     } else {
/* 192 */       rowWriter.write(17, value17);
/* 193 */     }
/* 194 */
/* 195 */   }
/* 196 */
/* 197 */
/* 198 */   private void apply_6(InternalRow i) {
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
/* 227 */
/* 228 */     boolean isNull29 = i.isNullAt(29);
/* 229 */     double value29 = isNull29 ? -1.0 : (i.getDouble(29));
/* 230 */     if (isNull29) {
/* 231 */       rowWriter.setNullAt(29);
/* 232 */     } else {
/* 233 */       rowWriter.write(29, value29);
/* 234 */     }
/* 235 */
/* 236 */   }
/* 237 */
/* 238 */
/* 239 */   private void apply_0(InternalRow i) {
/* 240 */
/* 241 */
/* 242 */     boolean isNull = i.isNullAt(0);
/* 243 */     int value = isNull ? -1 : (i.getInt(0));
/* 244 */     if (isNull) {
/* 245 */       rowWriter.setNullAt(0);
/* 246 */     } else {
/* 247 */       rowWriter.write(0, value);
/* 248 */     }
/* 249 */
/* 250 */
/* 251 */     boolean isNull1 = i.isNullAt(1);
/* 252 */     int value1 = isNull1 ? -1 : (i.getInt(1));
/* 253 */     if (isNull1) {
/* 254 */       rowWriter.setNullAt(1);
/* 255 */     } else {
/* 256 */       rowWriter.write(1, value1);
/* 257 */     }
/* 258 */
/* 259 */
/* 260 */     boolean isNull2 = i.isNullAt(2);
/* 261 */     int value2 = isNull2 ? -1 : (i.getInt(2));
/* 262 */     if (isNull2) {
/* 263 */       rowWriter.setNullAt(2);
/* 264 */     } else {
/* 265 */       rowWriter.write(2, value2);
/* 266 */     }
/* 267 */
/* 268 */
/* 269 */     boolean isNull3 = i.isNullAt(3);
/* 270 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 271 */     if (isNull3) {
/* 272 */       rowWriter.setNullAt(3);
/* 273 */     } else {
/* 274 */       rowWriter.write(3, value3);
/* 275 */     }
/* 276 */
/* 277 */
/* 278 */     boolean isNull4 = i.isNullAt(4);
/* 279 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 280 */     if (isNull4) {
/* 281 */       rowWriter.setNullAt(4);
/* 282 */     } else {
/* 283 */       rowWriter.write(4, value4);
/* 284 */     }
/* 285 */
/* 286 */   }
/* 287 */
/* 288 */
/* 289 */   private void apply_2(InternalRow i) {
/* 290 */
/* 291 */
/* 292 */     boolean isNull10 = i.isNullAt(10);
/* 293 */     int value10 = isNull10 ? -1 : (i.getInt(10));
/* 294 */     if (isNull10) {
/* 295 */       rowWriter.setNullAt(10);
/* 296 */     } else {
/* 297 */       rowWriter.write(10, value10);
/* 298 */     }
/* 299 */
/* 300 */
/* 301 */     boolean isNull11 = i.isNullAt(11);
/* 302 */     int value11 = isNull11 ? -1 : (i.getInt(11));
/* 303 */     if (isNull11) {
/* 304 */       rowWriter.setNullAt(11);
/* 305 */     } else {
/* 306 */       rowWriter.write(11, value11);
/* 307 */     }
/* 308 */
/* 309 */
/* 310 */     boolean isNull12 = i.isNullAt(12);
/* 311 */     int value12 = isNull12 ? -1 : (i.getInt(12));
/* 312 */     if (isNull12) {
/* 313 */       rowWriter.setNullAt(12);
/* 314 */     } else {
/* 315 */       rowWriter.write(12, value12);
/* 316 */     }
/* 317 */
/* 318 */
/* 319 */     boolean isNull13 = i.isNullAt(13);
/* 320 */     int value13 = isNull13 ? -1 : (i.getInt(13));
/* 321 */     if (isNull13) {
/* 322 */       rowWriter.setNullAt(13);
/* 323 */     } else {
/* 324 */       rowWriter.write(13, value13);
/* 325 */     }
/* 326 */
/* 327 */   }
/* 328 */
/* 329 */
/* 330 */   private void apply_5(InternalRow i) {
/* 331 */
/* 332 */
/* 333 */     boolean isNull22 = i.isNullAt(22);
/* 334 */     double value22 = isNull22 ? -1.0 : (i.getDouble(22));
/* 335 */     if (isNull22) {
/* 336 */       rowWriter.setNullAt(22);
/* 337 */     } else {
/* 338 */       rowWriter.write(22, value22);
/* 339 */     }
/* 340 */
/* 341 */
/* 342 */     boolean isNull23 = i.isNullAt(23);
/* 343 */     double value23 = isNull23 ? -1.0 : (i.getDouble(23));
/* 344 */     if (isNull23) {
/* 345 */       rowWriter.setNullAt(23);
/* 346 */     } else {
/* 347 */       rowWriter.write(23, value23);
/* 348 */     }
/* 349 */
/* 350 */
/* 351 */     boolean isNull24 = i.isNullAt(24);
/* 352 */     double value24 = isNull24 ? -1.0 : (i.getDouble(24));
/* 353 */     if (isNull24) {
/* 354 */       rowWriter.setNullAt(24);
/* 355 */     } else {
/* 356 */       rowWriter.write(24, value24);
/* 357 */     }
/* 358 */
/* 359 */
/* 360 */     boolean isNull25 = i.isNullAt(25);
/* 361 */     double value25 = isNull25 ? -1.0 : (i.getDouble(25));
/* 362 */     if (isNull25) {
/* 363 */       rowWriter.setNullAt(25);
/* 364 */     } else {
/* 365 */       rowWriter.write(25, value25);
/* 366 */     }
/* 367 */
/* 368 */   }
/* 369 */
/* 370 */
/* 371 */   // Scala.Function1 need this
/* 372 */   public java.lang.Object apply(java.lang.Object row) {
/* 373 */     return apply((InternalRow) row);
/* 374 */   }
/* 375 */
/* 376 */   public UnsafeRow apply(InternalRow i) {
/* 377 */     rowWriter.zeroOutNullBytes();
/* 378 */     apply_0(i);
/* 379 */     apply_1(i);
/* 380 */     apply_2(i);
/* 381 */     apply_3(i);
/* 382 */     apply_4(i);
/* 383 */     apply_5(i);
/* 384 */     apply_6(i);
/* 385 */     apply_7(i);
/* 386 */     return result;
/* 387 */   }
/* 388 */ }
