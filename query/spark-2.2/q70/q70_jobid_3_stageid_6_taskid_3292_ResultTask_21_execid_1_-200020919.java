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
/* 014 */     result = new UnsafeRow(29);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 640);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 29);
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
/* 029 */     UTF8String value17 = isNull17 ? null : (i.getUTF8String(17));
/* 030 */     if (isNull17) {
/* 031 */       rowWriter.setNullAt(17);
/* 032 */     } else {
/* 033 */       rowWriter.write(17, value17);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull18 = i.isNullAt(18);
/* 038 */     UTF8String value18 = isNull18 ? null : (i.getUTF8String(18));
/* 039 */     if (isNull18) {
/* 040 */       rowWriter.setNullAt(18);
/* 041 */     } else {
/* 042 */       rowWriter.write(18, value18);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull19 = i.isNullAt(19);
/* 047 */     UTF8String value19 = isNull19 ? null : (i.getUTF8String(19));
/* 048 */     if (isNull19) {
/* 049 */       rowWriter.setNullAt(19);
/* 050 */     } else {
/* 051 */       rowWriter.write(19, value19);
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     boolean isNull20 = i.isNullAt(20);
/* 056 */     UTF8String value20 = isNull20 ? null : (i.getUTF8String(20));
/* 057 */     if (isNull20) {
/* 058 */       rowWriter.setNullAt(20);
/* 059 */     } else {
/* 060 */       rowWriter.write(20, value20);
/* 061 */     }
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */
/* 066 */   private void apply_1(InternalRow i) {
/* 067 */
/* 068 */
/* 069 */     boolean isNull4 = i.isNullAt(4);
/* 070 */     int value4 = isNull4 ? -1 : (i.getInt(4));
/* 071 */     if (isNull4) {
/* 072 */       rowWriter.setNullAt(4);
/* 073 */     } else {
/* 074 */       rowWriter.write(4, value4);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull5 = i.isNullAt(5);
/* 079 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 080 */     if (isNull5) {
/* 081 */       rowWriter.setNullAt(5);
/* 082 */     } else {
/* 083 */       rowWriter.write(5, value5);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull6 = i.isNullAt(6);
/* 088 */     int value6 = isNull6 ? -1 : (i.getInt(6));
/* 089 */     if (isNull6) {
/* 090 */       rowWriter.setNullAt(6);
/* 091 */     } else {
/* 092 */       rowWriter.write(6, value6);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull7 = i.isNullAt(7);
/* 097 */     int value7 = isNull7 ? -1 : (i.getInt(7));
/* 098 */     if (isNull7) {
/* 099 */       rowWriter.setNullAt(7);
/* 100 */     } else {
/* 101 */       rowWriter.write(7, value7);
/* 102 */     }
/* 103 */
/* 104 */
/* 105 */     boolean isNull8 = i.isNullAt(8);
/* 106 */     UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 107 */     if (isNull8) {
/* 108 */       rowWriter.setNullAt(8);
/* 109 */     } else {
/* 110 */       rowWriter.write(8, value8);
/* 111 */     }
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */
/* 116 */   private void apply_3(InternalRow i) {
/* 117 */
/* 118 */
/* 119 */     boolean isNull13 = i.isNullAt(13);
/* 120 */     UTF8String value13 = isNull13 ? null : (i.getUTF8String(13));
/* 121 */     if (isNull13) {
/* 122 */       rowWriter.setNullAt(13);
/* 123 */     } else {
/* 124 */       rowWriter.write(13, value13);
/* 125 */     }
/* 126 */
/* 127 */
/* 128 */     boolean isNull14 = i.isNullAt(14);
/* 129 */     int value14 = isNull14 ? -1 : (i.getInt(14));
/* 130 */     if (isNull14) {
/* 131 */       rowWriter.setNullAt(14);
/* 132 */     } else {
/* 133 */       rowWriter.write(14, value14);
/* 134 */     }
/* 135 */
/* 136 */
/* 137 */     boolean isNull15 = i.isNullAt(15);
/* 138 */     UTF8String value15 = isNull15 ? null : (i.getUTF8String(15));
/* 139 */     if (isNull15) {
/* 140 */       rowWriter.setNullAt(15);
/* 141 */     } else {
/* 142 */       rowWriter.write(15, value15);
/* 143 */     }
/* 144 */
/* 145 */
/* 146 */     boolean isNull16 = i.isNullAt(16);
/* 147 */     int value16 = isNull16 ? -1 : (i.getInt(16));
/* 148 */     if (isNull16) {
/* 149 */       rowWriter.setNullAt(16);
/* 150 */     } else {
/* 151 */       rowWriter.write(16, value16);
/* 152 */     }
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */
/* 157 */   private void apply_6(InternalRow i) {
/* 158 */
/* 159 */
/* 160 */     boolean isNull25 = i.isNullAt(25);
/* 161 */     UTF8String value25 = isNull25 ? null : (i.getUTF8String(25));
/* 162 */     if (isNull25) {
/* 163 */       rowWriter.setNullAt(25);
/* 164 */     } else {
/* 165 */       rowWriter.write(25, value25);
/* 166 */     }
/* 167 */
/* 168 */
/* 169 */     boolean isNull26 = i.isNullAt(26);
/* 170 */     UTF8String value26 = isNull26 ? null : (i.getUTF8String(26));
/* 171 */     if (isNull26) {
/* 172 */       rowWriter.setNullAt(26);
/* 173 */     } else {
/* 174 */       rowWriter.write(26, value26);
/* 175 */     }
/* 176 */
/* 177 */
/* 178 */     boolean isNull27 = i.isNullAt(27);
/* 179 */     double value27 = isNull27 ? -1.0 : (i.getDouble(27));
/* 180 */     if (isNull27) {
/* 181 */       rowWriter.setNullAt(27);
/* 182 */     } else {
/* 183 */       rowWriter.write(27, value27);
/* 184 */     }
/* 185 */
/* 186 */
/* 187 */     boolean isNull28 = i.isNullAt(28);
/* 188 */     double value28 = isNull28 ? -1.0 : (i.getDouble(28));
/* 189 */     if (isNull28) {
/* 190 */       rowWriter.setNullAt(28);
/* 191 */     } else {
/* 192 */       rowWriter.write(28, value28);
/* 193 */     }
/* 194 */
/* 195 */   }
/* 196 */
/* 197 */
/* 198 */   private void apply_0(InternalRow i) {
/* 199 */
/* 200 */
/* 201 */     boolean isNull = i.isNullAt(0);
/* 202 */     int value = isNull ? -1 : (i.getInt(0));
/* 203 */     if (isNull) {
/* 204 */       rowWriter.setNullAt(0);
/* 205 */     } else {
/* 206 */       rowWriter.write(0, value);
/* 207 */     }
/* 208 */
/* 209 */
/* 210 */     boolean isNull1 = i.isNullAt(1);
/* 211 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 212 */     if (isNull1) {
/* 213 */       rowWriter.setNullAt(1);
/* 214 */     } else {
/* 215 */       rowWriter.write(1, value1);
/* 216 */     }
/* 217 */
/* 218 */
/* 219 */     boolean isNull2 = i.isNullAt(2);
/* 220 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 221 */     if (isNull2) {
/* 222 */       rowWriter.setNullAt(2);
/* 223 */     } else {
/* 224 */       rowWriter.write(2, value2);
/* 225 */     }
/* 226 */
/* 227 */
/* 228 */     boolean isNull3 = i.isNullAt(3);
/* 229 */     UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 230 */     if (isNull3) {
/* 231 */       rowWriter.setNullAt(3);
/* 232 */     } else {
/* 233 */       rowWriter.write(3, value3);
/* 234 */     }
/* 235 */
/* 236 */   }
/* 237 */
/* 238 */
/* 239 */   private void apply_2(InternalRow i) {
/* 240 */
/* 241 */
/* 242 */     boolean isNull9 = i.isNullAt(9);
/* 243 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 244 */     if (isNull9) {
/* 245 */       rowWriter.setNullAt(9);
/* 246 */     } else {
/* 247 */       rowWriter.write(9, value9);
/* 248 */     }
/* 249 */
/* 250 */
/* 251 */     boolean isNull10 = i.isNullAt(10);
/* 252 */     int value10 = isNull10 ? -1 : (i.getInt(10));
/* 253 */     if (isNull10) {
/* 254 */       rowWriter.setNullAt(10);
/* 255 */     } else {
/* 256 */       rowWriter.write(10, value10);
/* 257 */     }
/* 258 */
/* 259 */
/* 260 */     boolean isNull11 = i.isNullAt(11);
/* 261 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(11));
/* 262 */     if (isNull11) {
/* 263 */       rowWriter.setNullAt(11);
/* 264 */     } else {
/* 265 */       rowWriter.write(11, value11);
/* 266 */     }
/* 267 */
/* 268 */
/* 269 */     boolean isNull12 = i.isNullAt(12);
/* 270 */     UTF8String value12 = isNull12 ? null : (i.getUTF8String(12));
/* 271 */     if (isNull12) {
/* 272 */       rowWriter.setNullAt(12);
/* 273 */     } else {
/* 274 */       rowWriter.write(12, value12);
/* 275 */     }
/* 276 */
/* 277 */   }
/* 278 */
/* 279 */
/* 280 */   private void apply_5(InternalRow i) {
/* 281 */
/* 282 */
/* 283 */     boolean isNull21 = i.isNullAt(21);
/* 284 */     UTF8String value21 = isNull21 ? null : (i.getUTF8String(21));
/* 285 */     if (isNull21) {
/* 286 */       rowWriter.setNullAt(21);
/* 287 */     } else {
/* 288 */       rowWriter.write(21, value21);
/* 289 */     }
/* 290 */
/* 291 */
/* 292 */     boolean isNull22 = i.isNullAt(22);
/* 293 */     UTF8String value22 = isNull22 ? null : (i.getUTF8String(22));
/* 294 */     if (isNull22) {
/* 295 */       rowWriter.setNullAt(22);
/* 296 */     } else {
/* 297 */       rowWriter.write(22, value22);
/* 298 */     }
/* 299 */
/* 300 */
/* 301 */     boolean isNull23 = i.isNullAt(23);
/* 302 */     UTF8String value23 = isNull23 ? null : (i.getUTF8String(23));
/* 303 */     if (isNull23) {
/* 304 */       rowWriter.setNullAt(23);
/* 305 */     } else {
/* 306 */       rowWriter.write(23, value23);
/* 307 */     }
/* 308 */
/* 309 */
/* 310 */     boolean isNull24 = i.isNullAt(24);
/* 311 */     UTF8String value24 = isNull24 ? null : (i.getUTF8String(24));
/* 312 */     if (isNull24) {
/* 313 */       rowWriter.setNullAt(24);
/* 314 */     } else {
/* 315 */       rowWriter.write(24, value24);
/* 316 */     }
/* 317 */
/* 318 */   }
/* 319 */
/* 320 */
/* 321 */   // Scala.Function1 need this
/* 322 */   public java.lang.Object apply(java.lang.Object row) {
/* 323 */     return apply((InternalRow) row);
/* 324 */   }
/* 325 */
/* 326 */   public UnsafeRow apply(InternalRow i) {
/* 327 */     holder.reset();
/* 328 */
/* 329 */     rowWriter.zeroOutNullBytes();
/* 330 */     apply_0(i);
/* 331 */     apply_1(i);
/* 332 */     apply_2(i);
/* 333 */     apply_3(i);
/* 334 */     apply_4(i);
/* 335 */     apply_5(i);
/* 336 */     apply_6(i);
/* 337 */     result.setTotalSize(holder.totalSize());
/* 338 */     return result;
/* 339 */   }
/* 340 */ }
