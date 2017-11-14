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
/* 028 */     final double value24 = -1.0;
/* 029 */     if (true) {
/* 030 */       rowWriter.setNullAt(24);
/* 031 */     } else {
/* 032 */       rowWriter.write(24, value24);
/* 033 */     }
/* 034 */
/* 035 */
/* 036 */     final double value25 = -1.0;
/* 037 */     if (true) {
/* 038 */       rowWriter.setNullAt(25);
/* 039 */     } else {
/* 040 */       rowWriter.write(25, value25);
/* 041 */     }
/* 042 */
/* 043 */
/* 044 */     final double value26 = -1.0;
/* 045 */     if (true) {
/* 046 */       rowWriter.setNullAt(26);
/* 047 */     } else {
/* 048 */       rowWriter.write(26, value26);
/* 049 */     }
/* 050 */
/* 051 */
/* 052 */     final double value27 = -1.0;
/* 053 */     if (true) {
/* 054 */       rowWriter.setNullAt(27);
/* 055 */     } else {
/* 056 */       rowWriter.write(27, value27);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     final double value28 = -1.0;
/* 061 */     if (true) {
/* 062 */       rowWriter.setNullAt(28);
/* 063 */     } else {
/* 064 */       rowWriter.write(28, value28);
/* 065 */     }
/* 066 */
/* 067 */
/* 068 */     final double value29 = -1.0;
/* 069 */     if (true) {
/* 070 */       rowWriter.setNullAt(29);
/* 071 */     } else {
/* 072 */       rowWriter.write(29, value29);
/* 073 */     }
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */
/* 078 */   private void apply_1(InternalRow i) {
/* 079 */
/* 080 */
/* 081 */     final double value6 = -1.0;
/* 082 */     if (true) {
/* 083 */       rowWriter.setNullAt(6);
/* 084 */     } else {
/* 085 */       rowWriter.write(6, value6);
/* 086 */     }
/* 087 */
/* 088 */
/* 089 */     final double value7 = -1.0;
/* 090 */     if (true) {
/* 091 */       rowWriter.setNullAt(7);
/* 092 */     } else {
/* 093 */       rowWriter.write(7, value7);
/* 094 */     }
/* 095 */
/* 096 */
/* 097 */     final double value8 = -1.0;
/* 098 */     if (true) {
/* 099 */       rowWriter.setNullAt(8);
/* 100 */     } else {
/* 101 */       rowWriter.write(8, value8);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     final double value9 = -1.0;
/* 106 */     if (true) {
/* 107 */       rowWriter.setNullAt(9);
/* 108 */     } else {
/* 109 */       rowWriter.write(9, value9);
/* 110 */     }
/* 111 */
/* 112 */
/* 113 */     final double value10 = -1.0;
/* 114 */     if (true) {
/* 115 */       rowWriter.setNullAt(10);
/* 116 */     } else {
/* 117 */       rowWriter.write(10, value10);
/* 118 */     }
/* 119 */
/* 120 */
/* 121 */     final double value11 = -1.0;
/* 122 */     if (true) {
/* 123 */       rowWriter.setNullAt(11);
/* 124 */     } else {
/* 125 */       rowWriter.write(11, value11);
/* 126 */     }
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */
/* 131 */   private void apply_3(InternalRow i) {
/* 132 */
/* 133 */
/* 134 */     final double value18 = -1.0;
/* 135 */     if (true) {
/* 136 */       rowWriter.setNullAt(18);
/* 137 */     } else {
/* 138 */       rowWriter.write(18, value18);
/* 139 */     }
/* 140 */
/* 141 */
/* 142 */     final double value19 = -1.0;
/* 143 */     if (true) {
/* 144 */       rowWriter.setNullAt(19);
/* 145 */     } else {
/* 146 */       rowWriter.write(19, value19);
/* 147 */     }
/* 148 */
/* 149 */
/* 150 */     final double value20 = -1.0;
/* 151 */     if (true) {
/* 152 */       rowWriter.setNullAt(20);
/* 153 */     } else {
/* 154 */       rowWriter.write(20, value20);
/* 155 */     }
/* 156 */
/* 157 */
/* 158 */     final double value21 = -1.0;
/* 159 */     if (true) {
/* 160 */       rowWriter.setNullAt(21);
/* 161 */     } else {
/* 162 */       rowWriter.write(21, value21);
/* 163 */     }
/* 164 */
/* 165 */
/* 166 */     final double value22 = -1.0;
/* 167 */     if (true) {
/* 168 */       rowWriter.setNullAt(22);
/* 169 */     } else {
/* 170 */       rowWriter.write(22, value22);
/* 171 */     }
/* 172 */
/* 173 */
/* 174 */     final double value23 = -1.0;
/* 175 */     if (true) {
/* 176 */       rowWriter.setNullAt(23);
/* 177 */     } else {
/* 178 */       rowWriter.write(23, value23);
/* 179 */     }
/* 180 */
/* 181 */   }
/* 182 */
/* 183 */
/* 184 */   private void apply_0(InternalRow i) {
/* 185 */
/* 186 */
/* 187 */     final double value = -1.0;
/* 188 */     if (true) {
/* 189 */       rowWriter.setNullAt(0);
/* 190 */     } else {
/* 191 */       rowWriter.write(0, value);
/* 192 */     }
/* 193 */
/* 194 */
/* 195 */     final double value1 = -1.0;
/* 196 */     if (true) {
/* 197 */       rowWriter.setNullAt(1);
/* 198 */     } else {
/* 199 */       rowWriter.write(1, value1);
/* 200 */     }
/* 201 */
/* 202 */
/* 203 */     final double value2 = -1.0;
/* 204 */     if (true) {
/* 205 */       rowWriter.setNullAt(2);
/* 206 */     } else {
/* 207 */       rowWriter.write(2, value2);
/* 208 */     }
/* 209 */
/* 210 */
/* 211 */     final double value3 = -1.0;
/* 212 */     if (true) {
/* 213 */       rowWriter.setNullAt(3);
/* 214 */     } else {
/* 215 */       rowWriter.write(3, value3);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     final double value4 = -1.0;
/* 220 */     if (true) {
/* 221 */       rowWriter.setNullAt(4);
/* 222 */     } else {
/* 223 */       rowWriter.write(4, value4);
/* 224 */     }
/* 225 */
/* 226 */
/* 227 */     final double value5 = -1.0;
/* 228 */     if (true) {
/* 229 */       rowWriter.setNullAt(5);
/* 230 */     } else {
/* 231 */       rowWriter.write(5, value5);
/* 232 */     }
/* 233 */
/* 234 */   }
/* 235 */
/* 236 */
/* 237 */   private void apply_2(InternalRow i) {
/* 238 */
/* 239 */
/* 240 */     final double value12 = -1.0;
/* 241 */     if (true) {
/* 242 */       rowWriter.setNullAt(12);
/* 243 */     } else {
/* 244 */       rowWriter.write(12, value12);
/* 245 */     }
/* 246 */
/* 247 */
/* 248 */     final double value13 = -1.0;
/* 249 */     if (true) {
/* 250 */       rowWriter.setNullAt(13);
/* 251 */     } else {
/* 252 */       rowWriter.write(13, value13);
/* 253 */     }
/* 254 */
/* 255 */
/* 256 */     final double value14 = -1.0;
/* 257 */     if (true) {
/* 258 */       rowWriter.setNullAt(14);
/* 259 */     } else {
/* 260 */       rowWriter.write(14, value14);
/* 261 */     }
/* 262 */
/* 263 */
/* 264 */     final double value15 = -1.0;
/* 265 */     if (true) {
/* 266 */       rowWriter.setNullAt(15);
/* 267 */     } else {
/* 268 */       rowWriter.write(15, value15);
/* 269 */     }
/* 270 */
/* 271 */
/* 272 */     final double value16 = -1.0;
/* 273 */     if (true) {
/* 274 */       rowWriter.setNullAt(16);
/* 275 */     } else {
/* 276 */       rowWriter.write(16, value16);
/* 277 */     }
/* 278 */
/* 279 */
/* 280 */     final double value17 = -1.0;
/* 281 */     if (true) {
/* 282 */       rowWriter.setNullAt(17);
/* 283 */     } else {
/* 284 */       rowWriter.write(17, value17);
/* 285 */     }
/* 286 */
/* 287 */   }
/* 288 */
/* 289 */
/* 290 */   private void apply_5(InternalRow i) {
/* 291 */
/* 292 */
/* 293 */     final double value30 = -1.0;
/* 294 */     if (true) {
/* 295 */       rowWriter.setNullAt(30);
/* 296 */     } else {
/* 297 */       rowWriter.write(30, value30);
/* 298 */     }
/* 299 */
/* 300 */
/* 301 */     final double value31 = -1.0;
/* 302 */     if (true) {
/* 303 */       rowWriter.setNullAt(31);
/* 304 */     } else {
/* 305 */       rowWriter.write(31, value31);
/* 306 */     }
/* 307 */
/* 308 */
/* 309 */     final double value32 = -1.0;
/* 310 */     if (true) {
/* 311 */       rowWriter.setNullAt(32);
/* 312 */     } else {
/* 313 */       rowWriter.write(32, value32);
/* 314 */     }
/* 315 */
/* 316 */
/* 317 */     final double value33 = -1.0;
/* 318 */     if (true) {
/* 319 */       rowWriter.setNullAt(33);
/* 320 */     } else {
/* 321 */       rowWriter.write(33, value33);
/* 322 */     }
/* 323 */
/* 324 */
/* 325 */     final double value34 = -1.0;
/* 326 */     if (true) {
/* 327 */       rowWriter.setNullAt(34);
/* 328 */     } else {
/* 329 */       rowWriter.write(34, value34);
/* 330 */     }
/* 331 */
/* 332 */
/* 333 */     final double value35 = -1.0;
/* 334 */     if (true) {
/* 335 */       rowWriter.setNullAt(35);
/* 336 */     } else {
/* 337 */       rowWriter.write(35, value35);
/* 338 */     }
/* 339 */
/* 340 */   }
/* 341 */
/* 342 */
/* 343 */   // Scala.Function1 need this
/* 344 */   public java.lang.Object apply(java.lang.Object row) {
/* 345 */     return apply((InternalRow) row);
/* 346 */   }
/* 347 */
/* 348 */   public UnsafeRow apply(InternalRow i) {
/* 349 */     rowWriter.zeroOutNullBytes();
/* 350 */     apply_0(i);
/* 351 */     apply_1(i);
/* 352 */     apply_2(i);
/* 353 */     apply_3(i);
/* 354 */     apply_4(i);
/* 355 */     apply_5(i);
/* 356 */     return result;
/* 357 */   }
/* 358 */ }
