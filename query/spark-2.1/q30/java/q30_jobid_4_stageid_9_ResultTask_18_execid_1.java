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
/* 015 */   private long smj_value4;
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
/* 150 */     project_result2 = new UnsafeRow(13);
/* 151 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 288);
/* 152 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 13);
/* 153 */
/* 154 */   }
/* 155 */
/* 156 */   private void wholestagecodegen_init_1() {
/* 157 */     bhj_result = new UnsafeRow(16);
/* 158 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 288);
/* 159 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 16);
/* 160 */     project_result1 = new UnsafeRow(14);
/* 161 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 288);
/* 162 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 14);
/* 163 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 164 */
/* 165 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 166 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 167 */
/* 168 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 169 */     bhj_result1 = new UnsafeRow(15);
/* 170 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 288);
/* 171 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 15);
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
/* 192 */           smj_value4 = smj_isNull2 ? -1L : (smj_leftRow.getLong(0));
/* 193 */           smj_isNull3 = smj_leftRow.isNullAt(1);
/* 194 */           smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 195 */         }
/* 196 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(1);
/* 197 */         UTF8String smj_value8 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(1));
/* 198 */         smj_numOutputRows.add(1);
/* 199 */
/* 200 */         // generate join key for stream side
/* 201 */
/* 202 */         // find matches from HashedRelation
/* 203 */         UnsafeRow bhj_matched = smj_isNull2 ? null: (UnsafeRow)bhj_relation.getValue(smj_value4);
/* 204 */         if (bhj_matched == null) continue;
/* 205 */
/* 206 */         bhj_numOutputRows.add(1);
/* 207 */
/* 208 */         boolean bhj_isNull3 = bhj_matched.isNullAt(2);
/* 209 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(2));
/* 210 */
/* 211 */         // generate join key for stream side
/* 212 */
/* 213 */         boolean bhj_isNull31 = bhj_isNull3;
/* 214 */         long bhj_value31 = -1L;
/* 215 */         if (!bhj_isNull3) {
/* 216 */           bhj_value31 = (long) bhj_value3;
/* 217 */         }
/* 218 */         // find matches from HashedRelation
/* 219 */         UnsafeRow bhj_matched1 = bhj_isNull31 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value31);
/* 220 */         if (bhj_matched1 == null) continue;
/* 221 */
/* 222 */         bhj_numOutputRows1.add(1);
/* 223 */
/* 224 */         boolean bhj_isNull2 = bhj_matched.isNullAt(1);
/* 225 */         UTF8String bhj_value2 = bhj_isNull2 ? null : (bhj_matched.getUTF8String(1));
/* 226 */         boolean bhj_isNull4 = bhj_matched.isNullAt(3);
/* 227 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(3));
/* 228 */         boolean bhj_isNull5 = bhj_matched.isNullAt(4);
/* 229 */         UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(4));
/* 230 */         boolean bhj_isNull6 = bhj_matched.isNullAt(5);
/* 231 */         UTF8String bhj_value6 = bhj_isNull6 ? null : (bhj_matched.getUTF8String(5));
/* 232 */         boolean bhj_isNull7 = bhj_matched.isNullAt(6);
/* 233 */         UTF8String bhj_value7 = bhj_isNull7 ? null : (bhj_matched.getUTF8String(6));
/* 234 */         boolean bhj_isNull8 = bhj_matched.isNullAt(7);
/* 235 */         int bhj_value8 = bhj_isNull8 ? -1 : (bhj_matched.getInt(7));
/* 236 */         boolean bhj_isNull9 = bhj_matched.isNullAt(8);
/* 237 */         int bhj_value9 = bhj_isNull9 ? -1 : (bhj_matched.getInt(8));
/* 238 */         boolean bhj_isNull10 = bhj_matched.isNullAt(9);
/* 239 */         int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched.getInt(9));
/* 240 */         boolean bhj_isNull11 = bhj_matched.isNullAt(10);
/* 241 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched.getUTF8String(10));
/* 242 */         boolean bhj_isNull12 = bhj_matched.isNullAt(11);
/* 243 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched.getUTF8String(11));
/* 244 */         boolean bhj_isNull13 = bhj_matched.isNullAt(12);
/* 245 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched.getUTF8String(12));
/* 246 */         boolean bhj_isNull14 = bhj_matched.isNullAt(13);
/* 247 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched.getUTF8String(13));
/* 248 */         project_holder2.reset();
/* 249 */
/* 250 */         project_rowWriter2.zeroOutNullBytes();
/* 251 */
/* 252 */         if (bhj_isNull2) {
/* 253 */           project_rowWriter2.setNullAt(0);
/* 254 */         } else {
/* 255 */           project_rowWriter2.write(0, bhj_value2);
/* 256 */         }
/* 257 */
/* 258 */         if (bhj_isNull4) {
/* 259 */           project_rowWriter2.setNullAt(1);
/* 260 */         } else {
/* 261 */           project_rowWriter2.write(1, bhj_value4);
/* 262 */         }
/* 263 */
/* 264 */         if (bhj_isNull5) {
/* 265 */           project_rowWriter2.setNullAt(2);
/* 266 */         } else {
/* 267 */           project_rowWriter2.write(2, bhj_value5);
/* 268 */         }
/* 269 */
/* 270 */         if (bhj_isNull6) {
/* 271 */           project_rowWriter2.setNullAt(3);
/* 272 */         } else {
/* 273 */           project_rowWriter2.write(3, bhj_value6);
/* 274 */         }
/* 275 */
/* 276 */         if (bhj_isNull7) {
/* 277 */           project_rowWriter2.setNullAt(4);
/* 278 */         } else {
/* 279 */           project_rowWriter2.write(4, bhj_value7);
/* 280 */         }
/* 281 */
/* 282 */         if (bhj_isNull8) {
/* 283 */           project_rowWriter2.setNullAt(5);
/* 284 */         } else {
/* 285 */           project_rowWriter2.write(5, bhj_value8);
/* 286 */         }
/* 287 */
/* 288 */         if (bhj_isNull9) {
/* 289 */           project_rowWriter2.setNullAt(6);
/* 290 */         } else {
/* 291 */           project_rowWriter2.write(6, bhj_value9);
/* 292 */         }
/* 293 */
/* 294 */         if (bhj_isNull10) {
/* 295 */           project_rowWriter2.setNullAt(7);
/* 296 */         } else {
/* 297 */           project_rowWriter2.write(7, bhj_value10);
/* 298 */         }
/* 299 */
/* 300 */         if (bhj_isNull11) {
/* 301 */           project_rowWriter2.setNullAt(8);
/* 302 */         } else {
/* 303 */           project_rowWriter2.write(8, bhj_value11);
/* 304 */         }
/* 305 */
/* 306 */         if (bhj_isNull12) {
/* 307 */           project_rowWriter2.setNullAt(9);
/* 308 */         } else {
/* 309 */           project_rowWriter2.write(9, bhj_value12);
/* 310 */         }
/* 311 */
/* 312 */         if (bhj_isNull13) {
/* 313 */           project_rowWriter2.setNullAt(10);
/* 314 */         } else {
/* 315 */           project_rowWriter2.write(10, bhj_value13);
/* 316 */         }
/* 317 */
/* 318 */         if (bhj_isNull14) {
/* 319 */           project_rowWriter2.setNullAt(11);
/* 320 */         } else {
/* 321 */           project_rowWriter2.write(11, bhj_value14);
/* 322 */         }
/* 323 */
/* 324 */         project_rowWriter2.write(12, smj_value6);
/* 325 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 326 */         append(project_result2.copy());
/* 327 */
/* 328 */       }
/* 329 */       if (shouldStop()) return;
/* 330 */     }
/* 331 */   }
/* 332 */ }
