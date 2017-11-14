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
/* 012 */   private long smj_value6;
/* 013 */   private long smj_value7;
/* 014 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 015 */   private long smj_value8;
/* 016 */   private long smj_value9;
/* 017 */   private int smj_value10;
/* 018 */   private boolean smj_isNull6;
/* 019 */   private int smj_value11;
/* 020 */   private boolean smj_isNull7;
/* 021 */   private int smj_value12;
/* 022 */   private boolean smj_isNull8;
/* 023 */   private int smj_value13;
/* 024 */   private boolean smj_isNull9;
/* 025 */   private double smj_value14;
/* 026 */   private boolean smj_isNull10;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 028 */   private UnsafeRow smj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 037 */   private UnsafeRow bhj_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 040 */   private UnsafeRow project_result1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 043 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 044 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 046 */   private UnsafeRow bhj_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 049 */   private UnsafeRow project_result2;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 052 */
/* 053 */   public GeneratedIterator(Object[] references) {
/* 054 */     this.references = references;
/* 055 */   }
/* 056 */
/* 057 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 058 */     partitionIndex = index;
/* 059 */     this.inputs = inputs;
/* 060 */     wholestagecodegen_init_0();
/* 061 */     wholestagecodegen_init_1();
/* 062 */     wholestagecodegen_init_2();
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void wholestagecodegen_init_0() {
/* 067 */     smj_leftInput = inputs[0];
/* 068 */     smj_rightInput = inputs[1];
/* 069 */
/* 070 */     smj_rightRow = null;
/* 071 */
/* 072 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 073 */
/* 074 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 075 */     smj_result = new UnsafeRow(7);
/* 076 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 077 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 7);
/* 078 */     project_result = new UnsafeRow(4);
/* 079 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 081 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 082 */
/* 083 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 084 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   private boolean findNextInnerJoinRows(
/* 089 */     scala.collection.Iterator leftIter,
/* 090 */     scala.collection.Iterator rightIter) {
/* 091 */     smj_leftRow = null;
/* 092 */     int comp = 0;
/* 093 */     while (smj_leftRow == null) {
/* 094 */       if (!leftIter.hasNext()) return false;
/* 095 */       smj_leftRow = (InternalRow) leftIter.next();
/* 096 */
/* 097 */       boolean smj_isNull1 = smj_leftRow.isNullAt(3);
/* 098 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(3));
/* 099 */       boolean smj_isNull = smj_isNull1;
/* 100 */       long smj_value = -1L;
/* 101 */       if (!smj_isNull1) {
/* 102 */         smj_value = (long) smj_value1;
/* 103 */       }
/* 104 */
/* 105 */       boolean smj_isNull3 = smj_leftRow.isNullAt(0);
/* 106 */       int smj_value3 = smj_isNull3 ? -1 : (smj_leftRow.getInt(0));
/* 107 */       boolean smj_isNull2 = smj_isNull3;
/* 108 */       long smj_value2 = -1L;
/* 109 */       if (!smj_isNull3) {
/* 110 */         smj_value2 = (long) smj_value3;
/* 111 */       }
/* 112 */       if (smj_isNull || smj_isNull2) {
/* 113 */         smj_leftRow = null;
/* 114 */         continue;
/* 115 */       }
/* 116 */       if (!smj_matches.isEmpty()) {
/* 117 */         comp = 0;
/* 118 */         if (comp == 0) {
/* 119 */           comp = (smj_value > smj_value8 ? 1 : smj_value < smj_value8 ? -1 : 0);
/* 120 */         }
/* 121 */         if (comp == 0) {
/* 122 */           comp = (smj_value2 > smj_value9 ? 1 : smj_value2 < smj_value9 ? -1 : 0);
/* 123 */         }
/* 124 */
/* 125 */         if (comp == 0) {
/* 126 */           return true;
/* 127 */         }
/* 128 */         smj_matches.clear();
/* 129 */       }
/* 130 */
/* 131 */       do {
/* 132 */         if (smj_rightRow == null) {
/* 133 */           if (!rightIter.hasNext()) {
/* 134 */             smj_value8 = smj_value;
/* 135 */             smj_value9 = smj_value2;
/* 136 */             return !smj_matches.isEmpty();
/* 137 */           }
/* 138 */           smj_rightRow = (InternalRow) rightIter.next();
/* 139 */
/* 140 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 141 */           long smj_value4 = smj_isNull4 ? -1L : (smj_rightRow.getLong(1));
/* 142 */
/* 143 */           boolean smj_isNull5 = smj_rightRow.isNullAt(0);
/* 144 */           long smj_value5 = smj_isNull5 ? -1L : (smj_rightRow.getLong(0));
/* 145 */           if (smj_isNull4 || smj_isNull5) {
/* 146 */             smj_rightRow = null;
/* 147 */             continue;
/* 148 */           }
/* 149 */           smj_value6 = smj_value4;
/* 150 */           smj_value7 = smj_value5;
/* 151 */         }
/* 152 */
/* 153 */         comp = 0;
/* 154 */         if (comp == 0) {
/* 155 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 156 */         }
/* 157 */         if (comp == 0) {
/* 158 */           comp = (smj_value2 > smj_value7 ? 1 : smj_value2 < smj_value7 ? -1 : 0);
/* 159 */         }
/* 160 */
/* 161 */         if (comp > 0) {
/* 162 */           smj_rightRow = null;
/* 163 */         } else if (comp < 0) {
/* 164 */           if (!smj_matches.isEmpty()) {
/* 165 */             smj_value8 = smj_value;
/* 166 */             smj_value9 = smj_value2;
/* 167 */             return true;
/* 168 */           }
/* 169 */           smj_leftRow = null;
/* 170 */         } else {
/* 171 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 172 */           smj_rightRow = null;;
/* 173 */         }
/* 174 */       } while (smj_leftRow != null);
/* 175 */     }
/* 176 */     return false; // unreachable
/* 177 */   }
/* 178 */
/* 179 */   private void wholestagecodegen_init_2() {
/* 180 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 12);
/* 181 */     project_result2 = new UnsafeRow(10);
/* 182 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 192);
/* 183 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 10);
/* 184 */
/* 185 */   }
/* 186 */
/* 187 */   private void wholestagecodegen_init_1() {
/* 188 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 189 */     bhj_result = new UnsafeRow(8);
/* 190 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 191 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 192 */     project_result1 = new UnsafeRow(6);
/* 193 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 96);
/* 194 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 6);
/* 195 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 196 */
/* 197 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 198 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 199 */
/* 200 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 201 */     bhj_result1 = new UnsafeRow(12);
/* 202 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 192);
/* 203 */
/* 204 */   }
/* 205 */
/* 206 */   protected void processNext() throws java.io.IOException {
/* 207 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 208 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 209 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 210 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 211 */       smj_value11 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 212 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 213 */       smj_value12 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 214 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 215 */       smj_value13 = smj_isNull9 ? -1 : (smj_leftRow.getInt(3));
/* 216 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 217 */       smj_value14 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 218 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 219 */       while (smj_iterator.hasNext()) {
/* 220 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 221 */
/* 222 */         smj_numOutputRows.add(1);
/* 223 */
/* 224 */         // generate join key for stream side
/* 225 */
/* 226 */         boolean bhj_isNull = smj_isNull8;
/* 227 */         long bhj_value = -1L;
/* 228 */         if (!smj_isNull8) {
/* 229 */           bhj_value = (long) smj_value12;
/* 230 */         }
/* 231 */         // find matches from HashedRelation
/* 232 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 233 */         if (bhj_matched == null) continue;
/* 234 */
/* 235 */         bhj_numOutputRows.add(1);
/* 236 */
/* 237 */         // generate join key for stream side
/* 238 */
/* 239 */         boolean bhj_isNull14 = smj_isNull6;
/* 240 */         long bhj_value14 = -1L;
/* 241 */         if (!smj_isNull6) {
/* 242 */           bhj_value14 = (long) smj_value10;
/* 243 */         }
/* 244 */         // find matches from HashedRelation
/* 245 */         UnsafeRow bhj_matched1 = bhj_isNull14 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value14);
/* 246 */         if (bhj_matched1 == null) continue;
/* 247 */
/* 248 */         bhj_numOutputRows1.add(1);
/* 249 */
/* 250 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 251 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 252 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 253 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 254 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 255 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 256 */         boolean bhj_isNull17 = bhj_matched1.isNullAt(1);
/* 257 */         double bhj_value17 = bhj_isNull17 ? -1.0 : (bhj_matched1.getDouble(1));
/* 258 */         boolean bhj_isNull18 = bhj_matched1.isNullAt(2);
/* 259 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(2));
/* 260 */         boolean bhj_isNull19 = bhj_matched1.isNullAt(3);
/* 261 */         UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched1.getUTF8String(3));
/* 262 */         boolean bhj_isNull20 = bhj_matched1.isNullAt(4);
/* 263 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched1.getUTF8String(4));
/* 264 */         boolean bhj_isNull21 = bhj_matched1.isNullAt(5);
/* 265 */         int bhj_value21 = bhj_isNull21 ? -1 : (bhj_matched1.getInt(5));
/* 266 */         project_holder2.reset();
/* 267 */
/* 268 */         project_rowWriter2.zeroOutNullBytes();
/* 269 */
/* 270 */         if (smj_isNull7) {
/* 271 */           project_rowWriter2.setNullAt(0);
/* 272 */         } else {
/* 273 */           project_rowWriter2.write(0, smj_value11);
/* 274 */         }
/* 275 */
/* 276 */         if (smj_isNull10) {
/* 277 */           project_rowWriter2.setNullAt(1);
/* 278 */         } else {
/* 279 */           project_rowWriter2.write(1, smj_value14);
/* 280 */         }
/* 281 */
/* 282 */         if (bhj_isNull3) {
/* 283 */           project_rowWriter2.setNullAt(2);
/* 284 */         } else {
/* 285 */           project_rowWriter2.write(2, bhj_value3);
/* 286 */         }
/* 287 */
/* 288 */         if (bhj_isNull4) {
/* 289 */           project_rowWriter2.setNullAt(3);
/* 290 */         } else {
/* 291 */           project_rowWriter2.write(3, bhj_value4);
/* 292 */         }
/* 293 */
/* 294 */         if (bhj_isNull5) {
/* 295 */           project_rowWriter2.setNullAt(4);
/* 296 */         } else {
/* 297 */           project_rowWriter2.write(4, bhj_value5);
/* 298 */         }
/* 299 */
/* 300 */         if (bhj_isNull17) {
/* 301 */           project_rowWriter2.setNullAt(5);
/* 302 */         } else {
/* 303 */           project_rowWriter2.write(5, bhj_value17);
/* 304 */         }
/* 305 */
/* 306 */         if (bhj_isNull18) {
/* 307 */           project_rowWriter2.setNullAt(6);
/* 308 */         } else {
/* 309 */           project_rowWriter2.write(6, bhj_value18);
/* 310 */         }
/* 311 */
/* 312 */         if (bhj_isNull19) {
/* 313 */           project_rowWriter2.setNullAt(7);
/* 314 */         } else {
/* 315 */           project_rowWriter2.write(7, bhj_value19);
/* 316 */         }
/* 317 */
/* 318 */         if (bhj_isNull20) {
/* 319 */           project_rowWriter2.setNullAt(8);
/* 320 */         } else {
/* 321 */           project_rowWriter2.write(8, bhj_value20);
/* 322 */         }
/* 323 */
/* 324 */         if (bhj_isNull21) {
/* 325 */           project_rowWriter2.setNullAt(9);
/* 326 */         } else {
/* 327 */           project_rowWriter2.write(9, bhj_value21);
/* 328 */         }
/* 329 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 330 */         append(project_result2.copy());
/* 331 */
/* 332 */       }
/* 333 */       if (shouldStop()) return;
/* 334 */     }
/* 335 */   }
/* 336 */ }
