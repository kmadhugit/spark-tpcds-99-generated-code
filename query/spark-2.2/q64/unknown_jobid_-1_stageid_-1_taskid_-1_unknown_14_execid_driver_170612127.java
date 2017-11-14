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
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private int smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private int smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private int smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private int smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private int smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private int smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private double smj_value11;
/* 030 */   private boolean smj_isNull9;
/* 031 */   private double smj_value12;
/* 032 */   private boolean smj_isNull10;
/* 033 */   private double smj_value13;
/* 034 */   private boolean smj_isNull11;
/* 035 */   private int smj_value14;
/* 036 */   private boolean smj_isNull12;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 038 */   private UnsafeRow smj_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 041 */   private UnsafeRow project_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 044 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 045 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 047 */   private UnsafeRow bhj_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 050 */   private UnsafeRow project_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 053 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 054 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 055 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 056 */   private UnsafeRow bhj_result1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 059 */   private UnsafeRow project_result2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 062 */
/* 063 */   public GeneratedIterator(Object[] references) {
/* 064 */     this.references = references;
/* 065 */   }
/* 066 */
/* 067 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 068 */     partitionIndex = index;
/* 069 */     this.inputs = inputs;
/* 070 */     wholestagecodegen_init_0();
/* 071 */     wholestagecodegen_init_1();
/* 072 */     wholestagecodegen_init_2();
/* 073 */
/* 074 */   }
/* 075 */
/* 076 */   private void wholestagecodegen_init_0() {
/* 077 */     smj_leftInput = inputs[0];
/* 078 */     smj_rightInput = inputs[1];
/* 079 */
/* 080 */     smj_rightRow = null;
/* 081 */
/* 082 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 083 */
/* 084 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 085 */     smj_result = new UnsafeRow(12);
/* 086 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 087 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 088 */     project_result = new UnsafeRow(11);
/* 089 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 090 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 091 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 092 */
/* 093 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 094 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 095 */
/* 096 */   }
/* 097 */
/* 098 */   private boolean findNextInnerJoinRows(
/* 099 */     scala.collection.Iterator leftIter,
/* 100 */     scala.collection.Iterator rightIter) {
/* 101 */     smj_leftRow = null;
/* 102 */     int comp = 0;
/* 103 */     while (smj_leftRow == null) {
/* 104 */       if (!leftIter.hasNext()) return false;
/* 105 */       smj_leftRow = (InternalRow) leftIter.next();
/* 106 */
/* 107 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 108 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 109 */       if (smj_isNull) {
/* 110 */         smj_leftRow = null;
/* 111 */         continue;
/* 112 */       }
/* 113 */       if (!smj_matches.isEmpty()) {
/* 114 */         comp = 0;
/* 115 */         if (comp == 0) {
/* 116 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 117 */         }
/* 118 */
/* 119 */         if (comp == 0) {
/* 120 */           return true;
/* 121 */         }
/* 122 */         smj_matches.clear();
/* 123 */       }
/* 124 */
/* 125 */       do {
/* 126 */         if (smj_rightRow == null) {
/* 127 */           if (!rightIter.hasNext()) {
/* 128 */             smj_value3 = smj_value;
/* 129 */             return !smj_matches.isEmpty();
/* 130 */           }
/* 131 */           smj_rightRow = (InternalRow) rightIter.next();
/* 132 */
/* 133 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 134 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 135 */           if (smj_isNull1) {
/* 136 */             smj_rightRow = null;
/* 137 */             continue;
/* 138 */           }
/* 139 */           smj_value2 = smj_value1;
/* 140 */         }
/* 141 */
/* 142 */         comp = 0;
/* 143 */         if (comp == 0) {
/* 144 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 145 */         }
/* 146 */
/* 147 */         if (comp > 0) {
/* 148 */           smj_rightRow = null;
/* 149 */         } else if (comp < 0) {
/* 150 */           if (!smj_matches.isEmpty()) {
/* 151 */             smj_value3 = smj_value;
/* 152 */             return true;
/* 153 */           }
/* 154 */           smj_leftRow = null;
/* 155 */         } else {
/* 156 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 157 */           smj_rightRow = null;;
/* 158 */         }
/* 159 */       } while (smj_leftRow != null);
/* 160 */     }
/* 161 */     return false; // unreachable
/* 162 */   }
/* 163 */
/* 164 */   private void wholestagecodegen_init_2() {
/* 165 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 14);
/* 166 */     project_result2 = new UnsafeRow(12);
/* 167 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 168 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 12);
/* 169 */
/* 170 */   }
/* 171 */
/* 172 */   private void wholestagecodegen_init_1() {
/* 173 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 174 */     bhj_result = new UnsafeRow(13);
/* 175 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 176 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 13);
/* 177 */     project_result1 = new UnsafeRow(11);
/* 178 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 179 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 11);
/* 180 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 181 */
/* 182 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 183 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 184 */
/* 185 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 186 */     bhj_result1 = new UnsafeRow(14);
/* 187 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */   protected void processNext() throws java.io.IOException {
/* 192 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 193 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 194 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 195 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 196 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 197 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 198 */       smj_value6 = smj_isNull4 ? -1 : (smj_leftRow.getInt(2));
/* 199 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 200 */       smj_value7 = smj_isNull5 ? -1 : (smj_leftRow.getInt(3));
/* 201 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 202 */       smj_value8 = smj_isNull6 ? -1 : (smj_leftRow.getInt(4));
/* 203 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 204 */       smj_value9 = smj_isNull7 ? -1 : (smj_leftRow.getInt(5));
/* 205 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 206 */       smj_value10 = smj_isNull8 ? -1 : (smj_leftRow.getInt(6));
/* 207 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 208 */       smj_value11 = smj_isNull9 ? -1.0 : (smj_leftRow.getDouble(7));
/* 209 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 210 */       smj_value12 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(8));
/* 211 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 212 */       smj_value13 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(9));
/* 213 */       smj_isNull12 = smj_leftRow.isNullAt(10);
/* 214 */       smj_value14 = smj_isNull12 ? -1 : (smj_leftRow.getInt(10));
/* 215 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 216 */       while (smj_iterator.hasNext()) {
/* 217 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 218 */
/* 219 */         smj_numOutputRows.add(1);
/* 220 */
/* 221 */         // generate join key for stream side
/* 222 */
/* 223 */         boolean bhj_isNull = smj_isNull12;
/* 224 */         long bhj_value = -1L;
/* 225 */         if (!smj_isNull12) {
/* 226 */           bhj_value = (long) smj_value14;
/* 227 */         }
/* 228 */         // find matches from HashedRelation
/* 229 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 230 */         if (bhj_matched == null) continue;
/* 231 */
/* 232 */         bhj_numOutputRows.add(1);
/* 233 */
/* 234 */         // generate join key for stream side
/* 235 */
/* 236 */         boolean bhj_isNull17 = smj_isNull7;
/* 237 */         long bhj_value17 = -1L;
/* 238 */         if (!smj_isNull7) {
/* 239 */           bhj_value17 = (long) smj_value9;
/* 240 */         }
/* 241 */         // find matches from HashedRelation
/* 242 */         UnsafeRow bhj_matched1 = bhj_isNull17 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value17);
/* 243 */         if (bhj_matched1 == null) continue;
/* 244 */
/* 245 */         bhj_numOutputRows1.add(1);
/* 246 */
/* 247 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 248 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 249 */         boolean bhj_isNull20 = bhj_matched1.isNullAt(1);
/* 250 */         UTF8String bhj_value20 = bhj_isNull20 ? null : (bhj_matched1.getUTF8String(1));
/* 251 */         boolean bhj_isNull21 = bhj_matched1.isNullAt(2);
/* 252 */         UTF8String bhj_value21 = bhj_isNull21 ? null : (bhj_matched1.getUTF8String(2));
/* 253 */         project_holder2.reset();
/* 254 */
/* 255 */         project_rowWriter2.zeroOutNullBytes();
/* 256 */
/* 257 */         if (smj_isNull2) {
/* 258 */           project_rowWriter2.setNullAt(0);
/* 259 */         } else {
/* 260 */           project_rowWriter2.write(0, smj_value4);
/* 261 */         }
/* 262 */
/* 263 */         if (smj_isNull3) {
/* 264 */           project_rowWriter2.setNullAt(1);
/* 265 */         } else {
/* 266 */           project_rowWriter2.write(1, smj_value5);
/* 267 */         }
/* 268 */
/* 269 */         if (smj_isNull4) {
/* 270 */           project_rowWriter2.setNullAt(2);
/* 271 */         } else {
/* 272 */           project_rowWriter2.write(2, smj_value6);
/* 273 */         }
/* 274 */
/* 275 */         if (smj_isNull5) {
/* 276 */           project_rowWriter2.setNullAt(3);
/* 277 */         } else {
/* 278 */           project_rowWriter2.write(3, smj_value7);
/* 279 */         }
/* 280 */
/* 281 */         if (smj_isNull6) {
/* 282 */           project_rowWriter2.setNullAt(4);
/* 283 */         } else {
/* 284 */           project_rowWriter2.write(4, smj_value8);
/* 285 */         }
/* 286 */
/* 287 */         if (smj_isNull8) {
/* 288 */           project_rowWriter2.setNullAt(5);
/* 289 */         } else {
/* 290 */           project_rowWriter2.write(5, smj_value10);
/* 291 */         }
/* 292 */
/* 293 */         if (smj_isNull9) {
/* 294 */           project_rowWriter2.setNullAt(6);
/* 295 */         } else {
/* 296 */           project_rowWriter2.write(6, smj_value11);
/* 297 */         }
/* 298 */
/* 299 */         if (smj_isNull10) {
/* 300 */           project_rowWriter2.setNullAt(7);
/* 301 */         } else {
/* 302 */           project_rowWriter2.write(7, smj_value12);
/* 303 */         }
/* 304 */
/* 305 */         if (smj_isNull11) {
/* 306 */           project_rowWriter2.setNullAt(8);
/* 307 */         } else {
/* 308 */           project_rowWriter2.write(8, smj_value13);
/* 309 */         }
/* 310 */
/* 311 */         if (bhj_isNull3) {
/* 312 */           project_rowWriter2.setNullAt(9);
/* 313 */         } else {
/* 314 */           project_rowWriter2.write(9, bhj_value3);
/* 315 */         }
/* 316 */
/* 317 */         if (bhj_isNull20) {
/* 318 */           project_rowWriter2.setNullAt(10);
/* 319 */         } else {
/* 320 */           project_rowWriter2.write(10, bhj_value20);
/* 321 */         }
/* 322 */
/* 323 */         if (bhj_isNull21) {
/* 324 */           project_rowWriter2.setNullAt(11);
/* 325 */         } else {
/* 326 */           project_rowWriter2.write(11, bhj_value21);
/* 327 */         }
/* 328 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 329 */         append(project_result2.copy());
/* 330 */
/* 331 */       }
/* 332 */       if (shouldStop()) return;
/* 333 */     }
/* 334 */   }
/* 335 */ }
