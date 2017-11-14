/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 030 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 032 */   private UnsafeRow bhj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 035 */   private UnsafeRow project_result1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 041 */   private UnsafeRow bhj_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 044 */   private UnsafeRow project_result2;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */     wholestagecodegen_init_2();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     scan_input = inputs[0];
/* 063 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 064 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 065 */     scan_scanTime1 = 0;
/* 066 */     scan_batch = null;
/* 067 */     scan_batchIdx = 0;
/* 068 */     scan_colInstance0 = null;
/* 069 */     scan_colInstance1 = null;
/* 070 */     scan_colInstance2 = null;
/* 071 */     scan_colInstance3 = null;
/* 072 */     scan_colInstance4 = null;
/* 073 */     scan_result = new UnsafeRow(5);
/* 074 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 075 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 076 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 077 */     filter_result = new UnsafeRow(5);
/* 078 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 079 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 080 */     project_result = new UnsafeRow(5);
/* 081 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 082 */
/* 083 */   }
/* 084 */
/* 085 */   private void scan_nextBatch() throws java.io.IOException {
/* 086 */     long getBatchStart = System.nanoTime();
/* 087 */     if (scan_input.hasNext()) {
/* 088 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 089 */       scan_numOutputRows.add(scan_batch.numRows());
/* 090 */       scan_batchIdx = 0;
/* 091 */       scan_colInstance0 = scan_batch.column(0);
/* 092 */       scan_colInstance1 = scan_batch.column(1);
/* 093 */       scan_colInstance2 = scan_batch.column(2);
/* 094 */       scan_colInstance3 = scan_batch.column(3);
/* 095 */       scan_colInstance4 = scan_batch.column(4);
/* 096 */
/* 097 */     }
/* 098 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 099 */   }
/* 100 */
/* 101 */   private void wholestagecodegen_init_2() {
/* 102 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 103 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 104 */
/* 105 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 106 */     bhj_result1 = new UnsafeRow(11);
/* 107 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 108 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 11);
/* 109 */     project_result2 = new UnsafeRow(9);
/* 110 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 111 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 9);
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */   private void wholestagecodegen_init_1() {
/* 116 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 117 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 118 */
/* 119 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 123 */     bhj_result = new UnsafeRow(10);
/* 124 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 125 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 10);
/* 126 */     project_result1 = new UnsafeRow(9);
/* 127 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 128 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 9);
/* 129 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   protected void processNext() throws java.io.IOException {
/* 134 */     if (scan_batch == null) {
/* 135 */       scan_nextBatch();
/* 136 */     }
/* 137 */     while (scan_batch != null) {
/* 138 */       int scan_numRows = scan_batch.numRows();
/* 139 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 140 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 141 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 142 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 143 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 144 */
/* 145 */         if (!(!(scan_isNull))) continue;
/* 146 */
/* 147 */         filter_numOutputRows.add(1);
/* 148 */
/* 149 */         // generate join key for stream side
/* 150 */
/* 151 */         boolean bhj_isNull = false;
/* 152 */         long bhj_value = -1L;
/* 153 */         if (!false) {
/* 154 */           bhj_value = (long) scan_value;
/* 155 */         }
/* 156 */         // find matches from HashedRelation
/* 157 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 158 */         if (bhj_matched == null) continue;
/* 159 */
/* 160 */         bhj_numOutputRows.add(1);
/* 161 */
/* 162 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 163 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 164 */
/* 165 */         // generate join key for stream side
/* 166 */
/* 167 */         boolean bhj_isNull17 = scan_isNull4;
/* 168 */         long bhj_value17 = -1L;
/* 169 */         if (!scan_isNull4) {
/* 170 */           bhj_value17 = (long) scan_value4;
/* 171 */         }
/* 172 */         // find matches from HashedRelation
/* 173 */         UnsafeRow bhj_matched1 = bhj_isNull17 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value17);
/* 174 */         if (bhj_matched1 == null) continue;
/* 175 */
/* 176 */         bhj_numOutputRows1.add(1);
/* 177 */
/* 178 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 179 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 180 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 181 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 182 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 183 */         double scan_value3 = scan_isNull3 ? -1.0 : (scan_colInstance3.getDouble(scan_rowIdx));
/* 184 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 185 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 186 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 187 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 188 */         boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 189 */         int bhj_value5 = bhj_isNull5 ? -1 : (bhj_matched.getInt(3));
/* 190 */         boolean bhj_isNull6 = bhj_matched.isNullAt(4);
/* 191 */         int bhj_value6 = bhj_isNull6 ? -1 : (bhj_matched.getInt(4));
/* 192 */         boolean bhj_isNull20 = bhj_matched1.isNullAt(1);
/* 193 */         int bhj_value20 = bhj_isNull20 ? -1 : (bhj_matched1.getInt(1));
/* 194 */         project_rowWriter2.zeroOutNullBytes();
/* 195 */
/* 196 */         project_rowWriter2.write(0, scan_value);
/* 197 */
/* 198 */         if (scan_isNull1) {
/* 199 */           project_rowWriter2.setNullAt(1);
/* 200 */         } else {
/* 201 */           project_rowWriter2.write(1, scan_value1);
/* 202 */         }
/* 203 */
/* 204 */         if (scan_isNull2) {
/* 205 */           project_rowWriter2.setNullAt(2);
/* 206 */         } else {
/* 207 */           project_rowWriter2.write(2, scan_value2);
/* 208 */         }
/* 209 */
/* 210 */         if (scan_isNull3) {
/* 211 */           project_rowWriter2.setNullAt(3);
/* 212 */         } else {
/* 213 */           project_rowWriter2.write(3, scan_value3);
/* 214 */         }
/* 215 */
/* 216 */         if (bhj_isNull3) {
/* 217 */           project_rowWriter2.setNullAt(4);
/* 218 */         } else {
/* 219 */           project_rowWriter2.write(4, bhj_value3);
/* 220 */         }
/* 221 */
/* 222 */         if (bhj_isNull4) {
/* 223 */           project_rowWriter2.setNullAt(5);
/* 224 */         } else {
/* 225 */           project_rowWriter2.write(5, bhj_value4);
/* 226 */         }
/* 227 */
/* 228 */         if (bhj_isNull5) {
/* 229 */           project_rowWriter2.setNullAt(6);
/* 230 */         } else {
/* 231 */           project_rowWriter2.write(6, bhj_value5);
/* 232 */         }
/* 233 */
/* 234 */         if (bhj_isNull6) {
/* 235 */           project_rowWriter2.setNullAt(7);
/* 236 */         } else {
/* 237 */           project_rowWriter2.write(7, bhj_value6);
/* 238 */         }
/* 239 */
/* 240 */         if (bhj_isNull20) {
/* 241 */           project_rowWriter2.setNullAt(8);
/* 242 */         } else {
/* 243 */           project_rowWriter2.write(8, bhj_value20);
/* 244 */         }
/* 245 */         append(project_result2);
/* 246 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 247 */       }
/* 248 */       scan_batchIdx = scan_numRows;
/* 249 */       scan_batch = null;
/* 250 */       scan_nextBatch();
/* 251 */     }
/* 252 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 253 */     scan_scanTime1 = 0;
/* 254 */   }
/* 255 */ }
