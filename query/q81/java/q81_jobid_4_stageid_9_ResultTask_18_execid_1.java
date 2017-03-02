/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private java.util.ArrayList smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private UTF8String smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 021 */   private UnsafeRow smj_result;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 024 */   private UnsafeRow project_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 036 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 037 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 039 */   private UnsafeRow bhj_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 042 */   private UnsafeRow project_result2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */     wholestagecodegen_init_2();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     smj_leftInput = inputs[0];
/* 061 */     smj_rightInput = inputs[1];
/* 062 */
/* 063 */     smj_rightRow = null;
/* 064 */
/* 065 */     smj_matches = new java.util.ArrayList();
/* 066 */
/* 067 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 068 */     smj_result = new UnsafeRow(5);
/* 069 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 070 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 071 */     project_result = new UnsafeRow(2);
/* 072 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 073 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 074 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 075 */
/* 076 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 077 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 078 */
/* 079 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private boolean findNextInnerJoinRows(
/* 084 */     scala.collection.Iterator leftIter,
/* 085 */     scala.collection.Iterator rightIter) {
/* 086 */     smj_leftRow = null;
/* 087 */     int comp = 0;
/* 088 */     while (smj_leftRow == null) {
/* 089 */       if (!leftIter.hasNext()) return false;
/* 090 */       smj_leftRow = (InternalRow) leftIter.next();
/* 091 */
/* 092 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 093 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(1));
/* 094 */       if (smj_isNull) {
/* 095 */         smj_leftRow = null;
/* 096 */         continue;
/* 097 */       }
/* 098 */       if (!smj_matches.isEmpty()) {
/* 099 */         comp = 0;
/* 100 */         if (comp == 0) {
/* 101 */           comp = smj_value.compare(smj_value3);
/* 102 */         }
/* 103 */
/* 104 */         if (comp == 0) {
/* 105 */           return true;
/* 106 */         }
/* 107 */         smj_matches.clear();
/* 108 */       }
/* 109 */
/* 110 */       do {
/* 111 */         if (smj_rightRow == null) {
/* 112 */           if (!rightIter.hasNext()) {
/* 113 */             smj_value3 = smj_value.clone();
/* 114 */             return !smj_matches.isEmpty();
/* 115 */           }
/* 116 */           smj_rightRow = (InternalRow) rightIter.next();
/* 117 */
/* 118 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 119 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(1));
/* 120 */           if (smj_isNull1) {
/* 121 */             smj_rightRow = null;
/* 122 */             continue;
/* 123 */           }
/* 124 */           smj_value2 = smj_value1.clone();
/* 125 */         }
/* 126 */
/* 127 */         comp = 0;
/* 128 */         if (comp == 0) {
/* 129 */           comp = smj_value.compare(smj_value2);
/* 130 */         }
/* 131 */
/* 132 */         if (comp > 0) {
/* 133 */           smj_rightRow = null;
/* 134 */         } else if (comp < 0) {
/* 135 */           if (!smj_matches.isEmpty()) {
/* 136 */             smj_value3 = smj_value.clone();
/* 137 */             return true;
/* 138 */           }
/* 139 */           smj_leftRow = null;
/* 140 */         } else {
/* 141 */           smj_matches.add(smj_rightRow.copy());
/* 142 */           smj_rightRow = null;;
/* 143 */         }
/* 144 */       } while (smj_leftRow != null);
/* 145 */     }
/* 146 */     return false; // unreachable
/* 147 */   }
/* 148 */
/* 149 */   private void wholestagecodegen_init_2() {
/* 150 */     project_result2 = new UnsafeRow(16);
/* 151 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 448);
/* 152 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 16);
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */   private void wholestagecodegen_init_1() {
/* 157 */     bhj_result = new UnsafeRow(8);
/* 158 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 128);
/* 159 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 160 */     project_result1 = new UnsafeRow(6);
/* 161 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 162 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 163 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 164 */
/* 165 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 166 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 167 */
/* 168 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 169 */     bhj_result1 = new UnsafeRow(18);
/* 170 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 448);
/* 171 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 18);
/* 172 */
/* 173 */   }
/* 174 */
/* 175 */   protected void processNext() throws java.io.IOException {
/* 176 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 177 */       int smj_size = smj_matches.size();
/* 178 */       boolean smj_loaded = false;
/* 179 */       smj_value6 = smj_leftRow.getDouble(2);
/* 180 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 181 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 182 */         double smj_value7 = smj_rightRow1.getDouble(0);
/* 183 */
/* 184 */         boolean smj_isNull6 = false;
/* 185 */
/* 186 */         boolean smj_value9 = false;
/* 187 */         smj_value9 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value6, smj_value7) > 0;
/* 188 */         if (false || !smj_value9) continue;
/* 189 */         if (!smj_loaded) {
/* 190 */           smj_loaded = true;
/* 191 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 192 */           smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 193 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 194 */           smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 195 */         }
/* 196 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 197 */         UTF8String smj_value8 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 198 */         smj_numOutputRows.add(1);
/* 199 */
/* 200 */         // generate join key for stream side
/* 201 */
/* 202 */         boolean bhj_isNull = smj_isNull2;
/* 203 */         long bhj_value = -1L;
/* 204 */         if (!smj_isNull2) {
/* 205 */           bhj_value = (long) smj_value4;
/* 206 */         }
/* 207 */         // find matches from HashedRelation
/* 208 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 209 */         if (bhj_matched == null) continue;
/* 210 */
/* 211 */         bhj_numOutputRows.add(1);
/* 212 */
/* 213 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 214 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 215 */
/* 216 */         // generate join key for stream side
/* 217 */
/* 218 */         boolean bhj_isNull16 = bhj_isNull4;
/* 219 */         long bhj_value16 = -1L;
/* 220 */         if (!bhj_isNull4) {
/* 221 */           bhj_value16 = (long) bhj_value4;
/* 222 */         }
/* 223 */         // find matches from HashedRelation
/* 224 */         UnsafeRow bhj_matched1 = bhj_isNull16 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value16);
/* 225 */         if (bhj_matched1 == null) continue;
/* 226 */
/* 227 */         bhj_numOutputRows1.add(1);
/* 228 */
/* 229 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 230 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 231 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 232 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 233 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 234 */         UTF8String bhj_value6 = bhj_isNull6 ? null : (bhj_matched.getUTF8String(4));
/* 235 */         boolean bhj_isNull7 = bhj_matched.isNullAt(5);
/* 236 */         UTF8String bhj_value7 = bhj_isNull7 ? null : (bhj_matched.getUTF8String(5));
/* 237 */         boolean bhj_isNull19 = bhj_matched1.isNullAt(1);
/* 238 */         UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched1.getUTF8String(1));
/* 239 */         boolean bhj_isNull20 = bhj_matched1.isNullAt(2);
/* 240 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched1.getUTF8String(2));
/* 241 */         boolean bhj_isNull21 = bhj_matched1.isNullAt(3);
/* 242 */         UTF8String bhj_value21 = bhj_isNull21 ? null : (bhj_matched1.getUTF8String(3));
/* 243 */         boolean bhj_isNull22 = bhj_matched1.isNullAt(4);
/* 244 */         UTF8String bhj_value22 = bhj_isNull22 ? null : (bhj_matched1.getUTF8String(4));
/* 245 */         boolean bhj_isNull23 = bhj_matched1.isNullAt(5);
/* 246 */         UTF8String bhj_value23 = bhj_isNull23 ? null : (bhj_matched1.getUTF8String(5));
/* 247 */         boolean bhj_isNull24 = bhj_matched1.isNullAt(6);
/* 248 */         UTF8String bhj_value24 = bhj_isNull24 ? null : (bhj_matched1.getUTF8String(6));
/* 249 */         boolean bhj_isNull25 = bhj_matched1.isNullAt(7);
/* 250 */         UTF8String bhj_value25 = bhj_isNull25 ? null : (bhj_matched1.getUTF8String(7));
/* 251 */         boolean bhj_isNull26 = bhj_matched1.isNullAt(8);
/* 252 */         UTF8String bhj_value26 = bhj_isNull26 ? null : (bhj_matched1.getUTF8String(8));
/* 253 */         boolean bhj_isNull27 = bhj_matched1.isNullAt(9);
/* 254 */         UTF8String bhj_value27 = bhj_isNull27 ? null : (bhj_matched1.getUTF8String(9));
/* 255 */         boolean bhj_isNull28 = bhj_matched1.isNullAt(10);
/* 256 */         double bhj_value28 = bhj_isNull28 ? -1.0 : (bhj_matched1.getDouble(10));
/* 257 */         boolean bhj_isNull29 = bhj_matched1.isNullAt(11);
/* 258 */         UTF8String bhj_value29 = bhj_isNull29 ? null : (bhj_matched1.getUTF8String(11));
/* 259 */         project_holder2.reset();
/* 260 */
/* 261 */         project_rowWriter2.zeroOutNullBytes();
/* 262 */
/* 263 */         if (bhj_isNull3) {
/* 264 */           project_rowWriter2.setNullAt(0);
/* 265 */         } else {
/* 266 */           project_rowWriter2.write(0, bhj_value3);
/* 267 */         }
/* 268 */
/* 269 */         if (bhj_isNull5) {
/* 270 */           project_rowWriter2.setNullAt(1);
/* 271 */         } else {
/* 272 */           project_rowWriter2.write(1, bhj_value5);
/* 273 */         }
/* 274 */
/* 275 */         if (bhj_isNull6) {
/* 276 */           project_rowWriter2.setNullAt(2);
/* 277 */         } else {
/* 278 */           project_rowWriter2.write(2, bhj_value6);
/* 279 */         }
/* 280 */
/* 281 */         if (bhj_isNull7) {
/* 282 */           project_rowWriter2.setNullAt(3);
/* 283 */         } else {
/* 284 */           project_rowWriter2.write(3, bhj_value7);
/* 285 */         }
/* 286 */
/* 287 */         if (bhj_isNull19) {
/* 288 */           project_rowWriter2.setNullAt(4);
/* 289 */         } else {
/* 290 */           project_rowWriter2.write(4, bhj_value19);
/* 291 */         }
/* 292 */
/* 293 */         if (bhj_isNull20) {
/* 294 */           project_rowWriter2.setNullAt(5);
/* 295 */         } else {
/* 296 */           project_rowWriter2.write(5, bhj_value20);
/* 297 */         }
/* 298 */
/* 299 */         if (bhj_isNull21) {
/* 300 */           project_rowWriter2.setNullAt(6);
/* 301 */         } else {
/* 302 */           project_rowWriter2.write(6, bhj_value21);
/* 303 */         }
/* 304 */
/* 305 */         if (bhj_isNull22) {
/* 306 */           project_rowWriter2.setNullAt(7);
/* 307 */         } else {
/* 308 */           project_rowWriter2.write(7, bhj_value22);
/* 309 */         }
/* 310 */
/* 311 */         if (bhj_isNull23) {
/* 312 */           project_rowWriter2.setNullAt(8);
/* 313 */         } else {
/* 314 */           project_rowWriter2.write(8, bhj_value23);
/* 315 */         }
/* 316 */
/* 317 */         if (bhj_isNull24) {
/* 318 */           project_rowWriter2.setNullAt(9);
/* 319 */         } else {
/* 320 */           project_rowWriter2.write(9, bhj_value24);
/* 321 */         }
/* 322 */
/* 323 */         if (bhj_isNull25) {
/* 324 */           project_rowWriter2.setNullAt(10);
/* 325 */         } else {
/* 326 */           project_rowWriter2.write(10, bhj_value25);
/* 327 */         }
/* 328 */
/* 329 */         if (bhj_isNull26) {
/* 330 */           project_rowWriter2.setNullAt(11);
/* 331 */         } else {
/* 332 */           project_rowWriter2.write(11, bhj_value26);
/* 333 */         }
/* 334 */
/* 335 */         if (bhj_isNull27) {
/* 336 */           project_rowWriter2.setNullAt(12);
/* 337 */         } else {
/* 338 */           project_rowWriter2.write(12, bhj_value27);
/* 339 */         }
/* 340 */
/* 341 */         if (bhj_isNull28) {
/* 342 */           project_rowWriter2.setNullAt(13);
/* 343 */         } else {
/* 344 */           project_rowWriter2.write(13, bhj_value28);
/* 345 */         }
/* 346 */
/* 347 */         if (bhj_isNull29) {
/* 348 */           project_rowWriter2.setNullAt(14);
/* 349 */         } else {
/* 350 */           project_rowWriter2.write(14, bhj_value29);
/* 351 */         }
/* 352 */
/* 353 */         project_rowWriter2.write(15, smj_value6);
/* 354 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 355 */         append(project_result2.copy());
/* 356 */
/* 357 */       }
/* 358 */       if (shouldStop()) return;
/* 359 */     }
/* 360 */   }
/* 361 */ }
