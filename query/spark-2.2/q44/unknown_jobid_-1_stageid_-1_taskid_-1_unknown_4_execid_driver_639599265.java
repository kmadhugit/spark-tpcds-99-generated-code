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
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 020 */   private UnsafeRow smj_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 023 */   private UnsafeRow project_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 026 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 027 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 032 */   private UnsafeRow project_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 035 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 036 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 038 */   private UnsafeRow bhj_result1;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 041 */   private UnsafeRow project_result2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 044 */
/* 045 */   public GeneratedIterator(Object[] references) {
/* 046 */     this.references = references;
/* 047 */   }
/* 048 */
/* 049 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 050 */     partitionIndex = index;
/* 051 */     this.inputs = inputs;
/* 052 */     wholestagecodegen_init_0();
/* 053 */     wholestagecodegen_init_1();
/* 054 */     wholestagecodegen_init_2();
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void wholestagecodegen_init_0() {
/* 059 */     smj_leftInput = inputs[0];
/* 060 */     smj_rightInput = inputs[1];
/* 061 */
/* 062 */     smj_rightRow = null;
/* 063 */
/* 064 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 065 */
/* 066 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 067 */     smj_result = new UnsafeRow(4);
/* 068 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 069 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 4);
/* 070 */     project_result = new UnsafeRow(3);
/* 071 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 072 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 073 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[1];
/* 074 */
/* 075 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 076 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   private boolean findNextInnerJoinRows(
/* 081 */     scala.collection.Iterator leftIter,
/* 082 */     scala.collection.Iterator rightIter) {
/* 083 */     smj_leftRow = null;
/* 084 */     int comp = 0;
/* 085 */     while (smj_leftRow == null) {
/* 086 */       if (!leftIter.hasNext()) return false;
/* 087 */       smj_leftRow = (InternalRow) leftIter.next();
/* 088 */
/* 089 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 090 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 091 */       if (smj_isNull) {
/* 092 */         smj_leftRow = null;
/* 093 */         continue;
/* 094 */       }
/* 095 */       if (!smj_matches.isEmpty()) {
/* 096 */         comp = 0;
/* 097 */         if (comp == 0) {
/* 098 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 099 */         }
/* 100 */
/* 101 */         if (comp == 0) {
/* 102 */           return true;
/* 103 */         }
/* 104 */         smj_matches.clear();
/* 105 */       }
/* 106 */
/* 107 */       do {
/* 108 */         if (smj_rightRow == null) {
/* 109 */           if (!rightIter.hasNext()) {
/* 110 */             smj_value3 = smj_value;
/* 111 */             return !smj_matches.isEmpty();
/* 112 */           }
/* 113 */           smj_rightRow = (InternalRow) rightIter.next();
/* 114 */
/* 115 */           boolean smj_isNull1 = smj_rightRow.isNullAt(1);
/* 116 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(1));
/* 117 */           if (smj_isNull1) {
/* 118 */             smj_rightRow = null;
/* 119 */             continue;
/* 120 */           }
/* 121 */           smj_value2 = smj_value1;
/* 122 */         }
/* 123 */
/* 124 */         comp = 0;
/* 125 */         if (comp == 0) {
/* 126 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 127 */         }
/* 128 */
/* 129 */         if (comp > 0) {
/* 130 */           smj_rightRow = null;
/* 131 */         } else if (comp < 0) {
/* 132 */           if (!smj_matches.isEmpty()) {
/* 133 */             smj_value3 = smj_value;
/* 134 */             return true;
/* 135 */           }
/* 136 */           smj_leftRow = null;
/* 137 */         } else {
/* 138 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 139 */           smj_rightRow = null;;
/* 140 */         }
/* 141 */       } while (smj_leftRow != null);
/* 142 */     }
/* 143 */     return false; // unreachable
/* 144 */   }
/* 145 */
/* 146 */   private void wholestagecodegen_init_2() {
/* 147 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 148 */     project_result2 = new UnsafeRow(3);
/* 149 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 150 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 151 */
/* 152 */   }
/* 153 */
/* 154 */   private void wholestagecodegen_init_1() {
/* 155 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 156 */     bhj_result = new UnsafeRow(5);
/* 157 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 158 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 159 */     project_result1 = new UnsafeRow(3);
/* 160 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 161 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 162 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 163 */
/* 164 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 165 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 166 */
/* 167 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 168 */     bhj_result1 = new UnsafeRow(5);
/* 169 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 170 */
/* 171 */   }
/* 172 */
/* 173 */   protected void processNext() throws java.io.IOException {
/* 174 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 175 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 176 */       smj_value4 = smj_isNull2 ? -1 : (smj_leftRow.getInt(0));
/* 177 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 178 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 179 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 180 */       while (smj_iterator.hasNext()) {
/* 181 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 182 */
/* 183 */         smj_numOutputRows.add(1);
/* 184 */
/* 185 */         // generate join key for stream side
/* 186 */
/* 187 */         boolean bhj_isNull = smj_isNull2;
/* 188 */         long bhj_value = -1L;
/* 189 */         if (!smj_isNull2) {
/* 190 */           bhj_value = (long) smj_value4;
/* 191 */         }
/* 192 */         // find matches from HashedRelation
/* 193 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 194 */         if (bhj_matched == null) continue;
/* 195 */
/* 196 */         bhj_numOutputRows.add(1);
/* 197 */
/* 198 */         boolean smj_isNull4 = smj_rightRow1.isNullAt(0);
/* 199 */         int smj_value6 = smj_isNull4 ? -1 : (smj_rightRow1.getInt(0));
/* 200 */
/* 201 */         // generate join key for stream side
/* 202 */
/* 203 */         boolean bhj_isNull9 = smj_isNull4;
/* 204 */         long bhj_value9 = -1L;
/* 205 */         if (!smj_isNull4) {
/* 206 */           bhj_value9 = (long) smj_value6;
/* 207 */         }
/* 208 */         // find matches from HashedRelation
/* 209 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 210 */         if (bhj_matched1 == null) continue;
/* 211 */
/* 212 */         bhj_numOutputRows1.add(1);
/* 213 */
/* 214 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 215 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 216 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 217 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 218 */         project_holder2.reset();
/* 219 */
/* 220 */         project_rowWriter2.zeroOutNullBytes();
/* 221 */
/* 222 */         if (smj_isNull3) {
/* 223 */           project_rowWriter2.setNullAt(0);
/* 224 */         } else {
/* 225 */           project_rowWriter2.write(0, smj_value5);
/* 226 */         }
/* 227 */
/* 228 */         if (bhj_isNull3) {
/* 229 */           project_rowWriter2.setNullAt(1);
/* 230 */         } else {
/* 231 */           project_rowWriter2.write(1, bhj_value3);
/* 232 */         }
/* 233 */
/* 234 */         if (bhj_isNull12) {
/* 235 */           project_rowWriter2.setNullAt(2);
/* 236 */         } else {
/* 237 */           project_rowWriter2.write(2, bhj_value12);
/* 238 */         }
/* 239 */         project_result2.setTotalSize(project_holder2.totalSize());
/* 240 */         append(project_result2.copy());
/* 241 */
/* 242 */       }
/* 243 */       if (shouldStop()) return;
/* 244 */     }
/* 245 */   }
/* 246 */ }
