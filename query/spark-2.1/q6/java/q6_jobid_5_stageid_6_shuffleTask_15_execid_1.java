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
/* 016 */   private UnsafeRow scan_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 020 */   private UnsafeRow filter_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
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
/* 044 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 045 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 047 */   private UnsafeRow bhj_result2;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 050 */   private UnsafeRow project_result3;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 053 */
/* 054 */   public GeneratedIterator(Object[] references) {
/* 055 */     this.references = references;
/* 056 */   }
/* 057 */
/* 058 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 059 */     partitionIndex = index;
/* 060 */     this.inputs = inputs;
/* 061 */     wholestagecodegen_init_0();
/* 062 */     wholestagecodegen_init_1();
/* 063 */     wholestagecodegen_init_2();
/* 064 */     wholestagecodegen_init_3();
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void wholestagecodegen_init_0() {
/* 069 */     scan_input = inputs[0];
/* 070 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 071 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 072 */     scan_scanTime1 = 0;
/* 073 */     scan_batch = null;
/* 074 */     scan_batchIdx = 0;
/* 075 */     scan_colInstance0 = null;
/* 076 */     scan_colInstance1 = null;
/* 077 */     scan_result = new UnsafeRow(2);
/* 078 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 079 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 080 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 081 */     filter_result = new UnsafeRow(2);
/* 082 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 083 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 084 */     project_result = new UnsafeRow(2);
/* 085 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 086 */
/* 087 */   }
/* 088 */
/* 089 */   private void wholestagecodegen_init_3() {
/* 090 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 091 */     bhj_result2 = new UnsafeRow(4);
/* 092 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 093 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 4);
/* 094 */     project_result3 = new UnsafeRow(2);
/* 095 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 096 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void scan_nextBatch() throws java.io.IOException {
/* 101 */     long getBatchStart = System.nanoTime();
/* 102 */     if (scan_input.hasNext()) {
/* 103 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 104 */       scan_numOutputRows.add(scan_batch.numRows());
/* 105 */       scan_batchIdx = 0;
/* 106 */       scan_colInstance0 = scan_batch.column(0);
/* 107 */       scan_colInstance1 = scan_batch.column(1);
/* 108 */
/* 109 */     }
/* 110 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 111 */   }
/* 112 */
/* 113 */   private void wholestagecodegen_init_2() {
/* 114 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 115 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 116 */
/* 117 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 118 */     bhj_result1 = new UnsafeRow(5);
/* 119 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 120 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 121 */     project_result2 = new UnsafeRow(3);
/* 122 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 123 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 124 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 125 */
/* 126 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 127 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void wholestagecodegen_init_1() {
/* 132 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 133 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 134 */
/* 135 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 136 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 137 */
/* 138 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 139 */     bhj_result = new UnsafeRow(4);
/* 140 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 141 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 142 */     project_result1 = new UnsafeRow(2);
/* 143 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 144 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 145 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 146 */
/* 147 */   }
/* 148 */
/* 149 */   protected void processNext() throws java.io.IOException {
/* 150 */     if (scan_batch == null) {
/* 151 */       scan_nextBatch();
/* 152 */     }
/* 153 */     while (scan_batch != null) {
/* 154 */       int numRows = scan_batch.numRows();
/* 155 */       while (scan_batchIdx < numRows) {
/* 156 */         int scan_rowIdx = scan_batchIdx++;
/* 157 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 158 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 159 */
/* 160 */         if (!(!(scan_isNull))) continue;
/* 161 */
/* 162 */         filter_numOutputRows.add(1);
/* 163 */
/* 164 */         // generate join key for stream side
/* 165 */
/* 166 */         boolean bhj_isNull = false;
/* 167 */         long bhj_value = -1L;
/* 168 */         if (!false) {
/* 169 */           bhj_value = (long) scan_value;
/* 170 */         }
/* 171 */         // find matches from HashRelation
/* 172 */         scala.collection.Iterator bhj_matches = bhj_isNull ? null : (scala.collection.Iterator)bhj_relation.get(bhj_value);
/* 173 */         if (bhj_matches == null) continue;
/* 174 */         while (bhj_matches.hasNext()) {
/* 175 */           UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 176 */
/* 177 */           bhj_numOutputRows.add(1);
/* 178 */
/* 179 */           boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 180 */           int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 181 */
/* 182 */           // generate join key for stream side
/* 183 */
/* 184 */           boolean bhj_isNull8 = bhj_isNull2;
/* 185 */           long bhj_value8 = -1L;
/* 186 */           if (!bhj_isNull2) {
/* 187 */             bhj_value8 = (long) bhj_value2;
/* 188 */           }
/* 189 */           // find matches from HashedRelation
/* 190 */           UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 191 */           if (bhj_matched1 == null) continue;
/* 192 */
/* 193 */           bhj_numOutputRows1.add(1);
/* 194 */
/* 195 */           boolean bhj_isNull12 = bhj_matched1.isNullAt(2);
/* 196 */           int bhj_value12 = bhj_isNull12 ? -1 : (bhj_matched1.getInt(2));
/* 197 */
/* 198 */           // generate join key for stream side
/* 199 */
/* 200 */           boolean bhj_isNull18 = bhj_isNull12;
/* 201 */           long bhj_value18 = -1L;
/* 202 */           if (!bhj_isNull12) {
/* 203 */             bhj_value18 = (long) bhj_value12;
/* 204 */           }
/* 205 */           // find matches from HashedRelation
/* 206 */           UnsafeRow bhj_matched2 = bhj_isNull18 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value18);
/* 207 */           if (bhj_matched2 == null) continue;
/* 208 */
/* 209 */           bhj_numOutputRows2.add(1);
/* 210 */
/* 211 */           boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 212 */           UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 213 */           boolean bhj_isNull10 = bhj_matched1.isNullAt(0);
/* 214 */           int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched1.getInt(0));
/* 215 */           project_holder3.reset();
/* 216 */
/* 217 */           project_rowWriter3.zeroOutNullBytes();
/* 218 */
/* 219 */           if (scan_isNull1) {
/* 220 */             project_rowWriter3.setNullAt(0);
/* 221 */           } else {
/* 222 */             project_rowWriter3.write(0, scan_value1);
/* 223 */           }
/* 224 */
/* 225 */           if (bhj_isNull10) {
/* 226 */             project_rowWriter3.setNullAt(1);
/* 227 */           } else {
/* 228 */             project_rowWriter3.write(1, bhj_value10);
/* 229 */           }
/* 230 */           project_result3.setTotalSize(project_holder3.totalSize());
/* 231 */           append(project_result3.copy());
/* 232 */
/* 233 */         }
/* 234 */         if (shouldStop()) return;
/* 235 */       }
/* 236 */       scan_batch = null;
/* 237 */       scan_nextBatch();
/* 238 */     }
/* 239 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 240 */     scan_scanTime1 = 0;
/* 241 */   }
/* 242 */ }
